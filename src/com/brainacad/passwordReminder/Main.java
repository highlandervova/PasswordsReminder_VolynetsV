package com.brainacad.passwordReminder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import static com.brainacad.passwordReminder.Language.*;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Record> records;
        String configFile = "PassReminder.config";
        Properties settings = new Properties();
        File databaseFile = new File("verysecretfile.dt");
        if (!databaseFile.exists()) {
            databaseFile.createNewFile();
        }
        try(FileInputStream fisConfig = new FileInputStream(configFile)){
            settings.load(fisConfig);
        }catch(IOException e){
            e.printStackTrace();
        }
        String language = settings.getProperty("language");
        setInterfaceLanguage(language);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println(MENU);
            System.out.println(DEFAULT_TEXT);
            int intMenu = scanner.nextInt();
            switch (intMenu) {
                case 1:
                    records=Util.readRecords(databaseFile);
                    if(records.size()==0){
                        System.out.println(USERS_EMPTY);
                    }
                    else {
                        Util.printRecords(records);
                    }
                    break;

                case 2:
                    System.out.println(ENTER_SITE);
                    String site = scanner.next();
                    System.out.println(ENTER_LOGIN);
                    String login = scanner.next();
                    String password;
                    System.out.println(PASSWORD_SELECT);
                    if(scanner.next().toUpperCase().equals("Y")){
                        System.out.println(PASSWORD_LENGTH);
                        int quantity = scanner.nextInt();
                        StringBuffer sb = new StringBuffer(quantity);
                        for (int i = 0; i < quantity; i ++) {
                            sb.append(RandomService.getRandomSymbol());
                        }
                        password = sb.toString();
                    }
                    else {
                        System.out.println(PASSWORD+'=');
                        password = scanner.next();
                    }
                    Util.saveRecords(new Record(site,login,password),databaseFile);
                    System.out.println(ADD_SUCCESSFUL);
                    break;

                case 3:
                    System.out.println(CHANGE_LANGUAGE);
                    ArrayList<String> listOfLanguages = listLanguages();
                    int n=1;
                    for (String s : listOfLanguages) {
                        System.out.println(n+". "+s.substring(0,2));
                        n++;
                    }
                    int langInput = scanner.nextInt();
                    setInterfaceLanguage(listOfLanguages.get(langInput-1).substring(0,2));
                    settings.setProperty("language",listOfLanguages.get(langInput-1).substring(0,2));
                    try(FileWriter fw = new FileWriter(new File(configFile))){
                        settings.store(fw,"");
                }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println(DEFAULT_TEXT);
            }
        }
    }
}
