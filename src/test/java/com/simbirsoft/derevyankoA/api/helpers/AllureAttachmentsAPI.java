package com.simbirsoft.derevyankoA.api.helpers;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.simbirsoft.derevyankoA.api.methods.BreedsAPI.BREED_NAME;
import static com.simbirsoft.derevyankoA.api.methods.BreedsAPI.breedID;
import static com.simbirsoft.derevyankoA.api.methods.ImagesAPI.imageURL;

public class AllureAttachmentsAPI {

    @Attachment(value = "{attachName}", type = "text/plain")
    public static byte[] attachAsTextFile(String attachName) throws IOException {
        String data = String.format("Название породы: %s;\nID породы: %s;\nURL изображения: %s.", BREED_NAME, breedID, imageURL);
        Files.write(Paths.get("src/test/resources/attachments/attachment.txt"), data.getBytes());
        return Files.readAllBytes(Paths.get("src/test/resources/attachments", "attachment.txt"));
    }
}
