package ru.innopolis.stc.service;

public class Logger {
    final static org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Logger.class);

    public static void AddSuccessfulLoginInfo(String userLogin){
        LOGGER.info(userLogin + " successfully login");
    }

    public static void AddNotSuccessfulLoginInfo(String userLogin){
        LOGGER.info(userLogin + " has entered a wrong password");
    }
}
