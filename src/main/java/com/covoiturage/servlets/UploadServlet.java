package com.covoiturage.servlets;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


@MultipartConfig( fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5 )
public class UploadServlet extends HttpServlet {


    private static final String IMAGES_FOLDER = "/Images";
    public String uploadPath;
    @Override
    public void init() throws ServletException {
        uploadPath = getServletContext().getRealPath( IMAGES_FOLDER );
        File uploadDir = new File( uploadPath );
        System.out.println(uploadDir.toPath());
        if ( !uploadDir.exists() ) uploadDir.mkdir();

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        String fileName="-1";
        for ( Part part : request.getParts() ) {
            fileName = getFileName( part );
            String Name= "mazal";
            String fullPath = uploadPath + File.separator +Name+"."+getExtension(part);
            part.write( fullPath );
        }
        System.out.println(uploadPath+"\\"+fileName);
        request.setAttribute("path","/Images"+"/"+fileName);
        request.getRequestDispatcher("espace_user.jsp").forward(request,resp);
    }


    private String getFileName( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "=" ) + 2, content.length() - 1 );
        }
        return "Default.file";
    }
    private String getExtension( Part part ) {
        for ( String content : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( content.trim().startsWith( "filename" ) )
                return content.substring( content.indexOf( "." ) + 1, content.length() - 1 );
        }
        return "Default.file";
    }
}
