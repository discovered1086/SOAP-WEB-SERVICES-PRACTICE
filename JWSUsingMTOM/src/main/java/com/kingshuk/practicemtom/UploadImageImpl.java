package com.kingshuk.practicemtom;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by kingshuk on 11/14/17.
 */
@WebService(endpointInterface = "com.kingshuk.practicemtom.UploadImage", serviceName = "imageUpload")
public class UploadImageImpl implements UploadImage {

    /**
     * This is a user-defined method which takes a DataHandler class as the parameter.
     * DataHandler class is a fully implemented class that inherits the Transferable interface. This class
     * has Datasource Objects (Implementations of the DataSource interface) from which it can obtain
     * Input and Output streams and send it back to the caller method which in this case is the uploadImage method here
     *
     * Once the streams are received from the DataHandler, then writing to and reading from any file is possible
     * @param uploadedImage
     */
    @Override
    public void uploadImage(DataHandler uploadedImage) {
        try (InputStream inputStream = uploadedImage.getInputStream();
             FileOutputStream fileOutputStream=new FileOutputStream("/Volumes/Work/PROJECTS/Resources/uploaded/CSS.png")){

            int read;

            while((read=inputStream.read())!=-1){
                fileOutputStream.write(read);
            }

            System.out.println("Done uploading the file");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is for downloading a file which is called by the client to download a file.
     * Here specifying the XMLMimeType helps as the client knows what kind of a file is coming back (Is this correct??)
     *
     * Here we create a data source object (an implementation of the interface from the file and send it to the dataHandler.
     * Then the data Handler is returned instead of any stream. A stream can easily be obtained from the dataHandler object.
     * @return dataHandler reference
     */
    @Override
    public @XmlMimeType("application/octet-stream") DataHandler downloadFiles() {
        DataSource dataSource=new FileDataSource(new File("/Volumes/Work/PROJECTS/Resources/uploaded/CSS.png"));
        return new DataHandler(dataSource);
    }
}
