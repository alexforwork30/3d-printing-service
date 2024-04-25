package com.printingservice.controllers;

import com.printingservice.services.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @PostMapping("/{folderPath}")
    public String uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String folderPath) throws IOException {
        return fileService.uploadFile(file, folderPath);
    }
}
