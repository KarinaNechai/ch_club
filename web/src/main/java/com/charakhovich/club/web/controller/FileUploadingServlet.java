package com.charakhovich.club.web.controller;

import com.charakhovich.club.web.command.PageAttribute;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = {"/upload/*"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024
        , maxFileSize = 1024 * 1024 * 5
        , maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadingServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {
        String applicationDir = req.getServletContext().getRealPath("");

        String uploadFileDir = applicationDir + File.separator + UPLOAD_DIR + File.separator;

        File fileSaveDir = new File(uploadFileDir);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdirs();
        }
        req.getParts().stream().forEach(part -> {
            try {
                String path = part.getSubmittedFileName();
                String randFilename = UUID.randomUUID()+path.substring(path.lastIndexOf("."));//
                part.write(uploadFileDir  + randFilename);
                req.setAttribute(PageAttribute.UPLOAD_IMAGE_RESULT, 1);
                req.setAttribute(PageAttribute.IMAGE_NAME, randFilename);
            } catch (IOException e) {
                req.setAttribute("upload_result", " upload failed ");
            }
        });
        req.getRequestDispatcher("/jsp/upload_res.jsp").forward(req, resp);
    }
}