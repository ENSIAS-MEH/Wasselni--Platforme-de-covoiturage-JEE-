package com.covoiturage.servlets;

import com.covoiturage.beans.User;
import com.covoiturage.dao.DAOFactory;
import com.covoiturage.dao.implementations.UserDaoImp;
import com.covoiturage.dao.interfaces.UserDao;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;


@MultipartConfig( fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5 )
public class UploadServlet extends HttpServlet {


    private UserDao userDao;


    private static final String IMAGES_FOLDER = "/Images";
    public String uploadPath;
    @Override
    public void init() throws ServletException {
        this.userDao= ((DAOFactory) this.getServletContext().getAttribute("daofactory")).getUserDao();
        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        System.out.println(uploadDir.toPath());
        if ( !uploadDir.exists() ) uploadDir.mkdir();

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute("userSession"));

        String fileName="-1";
        for ( Part part : request.getParts() ) {
            fileName = getFileName( part );
            String fullPath = uploadPath + File.separator + fileName;
            user.setImage(fileName);
            try {
                userDao.updateUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            part.write( fullPath );
        }
        System.out.println(uploadPath+"\\"+fileName);
        request.setAttribute("path","/Images/"+user.getImage());
        request.getRequestDispatcher("/userAccueil").forward(request,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = ((User) session.getAttribute("userSession"));


        request.setAttribute("path","/Images/"+user.getImage());
        request.getRequestDispatcher("/userAccueil").forward(request,resp);
    }

    private String getFileName(Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }
    private String getExtension( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "." ) + 1, content.length() - 1 ).toUpperCase();
        }
        return "Default.file";
    }
}
