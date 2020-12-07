package com.brainacad.passwordReminder;

import java.io.*;
import java.util.Properties;
import java.util.ArrayList;


public class Language {
    //Default language will be English
    static String ENTER_SITE = "Enter site address";
    static String ENTER_LOGIN = "Enter your login";
    static String PASSWORD_SELECT = "Do you want to generate random password? Press 'Y' and Enter to generate or any other key to write own.";
    static String PASSWORD_LENGTH = "How many symbols should password have?";
    static String PASSWORD = "Password";
    static String MENU =
            "\nProgram menu:\n" +
            "1.Show all records.\n" +
            "2.Add new record.\n" +
            "3.Change interface language.\n" +
            "4.Close the program.";
    static String DEFAULT_TEXT = "Choose operation by pressing menu number and pressing Enter\n";
    static String ADD_SUCCESSFUL = "Record successfully added";
    static String USERS_EMPTY = "No records were entered";
    static String CHANGE_LANGUAGE = "To set another language enter corresponding number.";
    static String SITE="Site:";
    static String LOGIN="Login:";
    static String ENTRY_DATE="Entry date:";



    /** changes language of all static String variables that are used by interface
     *
     * @param language two symbols that represent language
     */
    static void setInterfaceLanguage(String language) {
        Properties lang = new Properties();
        try (FileInputStream fisLanguage = new FileInputStream(language+".lang");Reader reader = new InputStreamReader(fisLanguage,"UTF-8")) { //".lang"
            lang.load(reader);
            ENTER_SITE = lang.getProperty("ENTER_SITE");
            ENTER_LOGIN = lang.getProperty("ENTER_LOGIN");
            PASSWORD_SELECT = lang.getProperty("PASSWORD_SELECT");
            PASSWORD_LENGTH = lang.getProperty("PASSWORD_LENGTH");
            PASSWORD = lang.getProperty("PASSWORD");
            MENU = lang.getProperty("MENU");
            DEFAULT_TEXT = lang.getProperty("DEFAULT_TEXT");
            ADD_SUCCESSFUL = lang.getProperty("ADD_SUCCESSFUL");
            USERS_EMPTY = lang.getProperty("USERS_EMPTY");
            CHANGE_LANGUAGE = lang.getProperty("CHANGE_LANGUAGE");
            SITE=lang.getProperty("SITE");
            LOGIN=lang.getProperty("LOGIN");
            ENTRY_DATE=lang.getProperty("ENTRY_DATE");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

            static ArrayList<String> listLanguages() {
                final File folder = new File("").getAbsoluteFile();
                String pattern = ".*\\.lang";
                ArrayList<String> result = new ArrayList<>();
                for (final File f : folder.listFiles()) {
                    if (f.isFile()) {
                        if (f.getName().matches(pattern)) {
                            result.add(f.getName());
                        }
                    }

                }
                return result;

        }
    }

