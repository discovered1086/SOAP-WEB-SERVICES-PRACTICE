package com.kingshuk.practicemtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by kingshuk on 11/14/17.
 */
@WebService
public interface UploadImage {

    void uploadImage(@WebParam(name="image") DataHandler uploadedImage);

    DataHandler downloadFiles();
}
