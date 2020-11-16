package com.LeagueSocial.Services.utils;


import com.LeagueSocial.Domain.Account;
import com.LeagueSocial.Domain.Publication;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Service
public class PublicationUtils  {

    public PublicationUtils(){}

    public Date getTime(){
        SimpleDateFormat mask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            Date instant = mask.parse(java.time.LocalDateTime.now().
                    format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            return instant;
        }catch (ParseException e){
            throw new UnsupportedOperationException("horario informado não correspondente");
        }
    }


    public Publication ExistingPublisher(Integer id){return null;}

    public Void getAnyMidiaType(File file){
        return null;
    }

}
