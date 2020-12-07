package com.brainacad.passwordReminder;

import java.io.*;
import java.util.ArrayList;

public class Util {
    public static void printRecords(ArrayList<? extends Record> records) {
        int i = 1;
        for (Record record : records) {
            System.out.print((i++) + ") ");
            System.out.println(record);
        }
    }

    public static boolean saveRecords(Record record, File saveFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(saveFile, true))) {
            StringBuffer sb = new StringBuffer(30);
            sb.append(record.getSite()).append('\t').append(record.getLogin()).append('\t').append(record.getPassword()).append('\t').append(record.getRecordDate()).append("\n");
            System.out.println(sb.toString());
            bw.write(sb.toString());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Record> readRecords(File dataFile) {
        ArrayList<Record> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] stringRecord = line.split("\t");
                records.add(new Record(stringRecord[0], stringRecord[1], stringRecord[2], stringRecord[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
