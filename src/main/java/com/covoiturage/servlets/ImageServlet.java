package com.covoiturage.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String filename = request.getParameter( "filename" );
        if ( filename == null ) return;
        String fullPath = getServletContext().getRealPath("/Images")
                + File.separator + filename;

        System.out.println("ismail" +fullPath);
        File srcFile = new File( fullPath );
        byte [] buffer = new byte[(int)srcFile.length()];
        try ( FileInputStream inputStream = new FileInputStream(srcFile)) {
            inputStream.read(buffer);
        }
        response.setContentType( "image/png" );
        try {

            byte [] imageBytes =buffer ;
            try ( OutputStream outputStream = response.getOutputStream() ) {
                outputStream.write( imageBytes );
            }
        } catch( Exception exception ) {
            exception.printStackTrace();
        }

        request.setAttribute("path",request.getParameter("path"));
        request.getRequestDispatcher("/userAccueil").forward(request,response);

    }

}