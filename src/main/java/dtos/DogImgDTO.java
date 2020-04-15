package dtos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import utils.HttpUtils;

public class DogImgDTO implements DTOInterface{
    private String url;
    private String message;

    public String getUrl() {
        return url;
    }

    public String getMessage() {
        return message;
    }

    

    public DogImgDTO(String url) {
        this.url = url;
    }

    @Override
    public void fetch() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String str = HttpUtils.fetchData(this.url, "", "");
        DogImgDTO diDTO = gson.fromJson(str, DogImgDTO.class);
        this.message = diDTO.getMessage();
    }
    
    
}
