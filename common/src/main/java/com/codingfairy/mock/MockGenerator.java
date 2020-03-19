package com.codingfairy.mock;

import com.codingfairy.tool.DateFormatter;
import com.codingfairy.vo.PhoneJson;
import com.codingfairy.vo.ProbeJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MockGenerator {
    private static long count = 0;

    public static void main(String[] args) {
        int testNum = 8;
        for (int i = 0; i < testNum; i++) {
            //number of stores
            int storeNum = (int) Math.pow(2, i);
            try {
                long currentHour = System.currentTimeMillis()/(3600*1000);
                System.out.println("current time: " + (currentHour-2)*3600000);
                String json = GsonTool.convertObjectToJson(generate(storeNum,
                        (currentHour-11L)*3600000L,(currentHour-1L)*3600000L,30000));
                //write into data
                System.out.println("total probe data number: " + count);
                String filePath = "./input_data/10h_30s_" + storeNum + "store_" + count + ".json";
                FileWriter fileWriter = new FileWriter(new File(filePath));
                fileWriter.write(json);
                fileWriter.flush();
                fileWriter.close();

                count = 0; //reset count

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//        try {
//            long currentHour = System.currentTimeMillis()/(3600*1000);
//            System.out.println("current time: " + (currentHour-2)*3600000);
//            String json = GsonTool.convertObjectToJson(generate(10,
//                    (currentHour-17)*3600000L,(currentHour-1L)*3600000L,30000));
//
//            FileWriter fileWriter = new FileWriter(new File("./input_data/16h_30s_10s.txt"));
//            fileWriter.write(json);
//            fileWriter.flush();
//            fileWriter.close();
//            System.out.println("total probe data number: " + count);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    //random mac
    public static ArrayList<String> randomMac(int num) {

        ArrayList<String> macAdd = new ArrayList();
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            String[] mac = {
                    String.format("%02x", 0x52),
                    String.format("%02x", 0x54),
                    String.format("%02x", 0x00),
                    String.format("%02x", random.nextInt(0xff)),
                    String.format("%02x", random.nextInt(0xff)),
                    String.format("%02x", random.nextInt(0xff))
            };
            macAdd.add(String.join(":", mac));
        }
        return macAdd;
    }

//    private static String[] macAdd = {
//            "00:00:00:00:00:00",
//            "11:11:11:11:11:11",
//            "22:22:22:22:22:22",
//            "33:33:33:33:33:33",
//            "44:44:44:44:44:44",
//            "55:55:55:55:55:55",
//            "66:66:66:66:66:66",
//            "77:77:77:77:77:77",
//            "88:88:88:88:88:88",
//    };

    /* poisson distribution variable */

//    private static double getPossionProbability(long k, long lamda){
//        double c = Math.exp(-lamda), sum = 1;
//        for (int i = 1; i <= k; i++) {
//            sum *= lamda / i;
//        }
//        return sum * c;
//    }
//
//    private static int getPossionVariable (long lamda, long rand){
//        int x = 0;
//        double y = Math.random(), cdf = getPossionProbability(x, lamda);
//        while (cdf < y) {
//            x++;
//            cdf += getPossionProbability(x, lamda);
//        }
////        if (x > rand) {
////            return getPossionVariable(lamda, rand);
////        }
//        System.out.println(x);
//        return x;
//    }

    public static List<ProbeJson> generate(int storeNum, long start, long end, long rand) throws Exception{

        String string = "[\n" +
                "  {\n" +
                "    \"id\": \"1s12sz\",\n" +
                "    \"mmac\": \"5e:cf:7f:10:f3:77\",\n" +
                "    \"rate\": \"3\",\n" +
                "    \"wssid\": \"codingfairy\",\n" +
                "    \"wmac\": \"a8:57:4e:c0:d4:8c\",\n" +
                "    \"time\": \"Thu Jan 01 08:00:00 1970\",\n" +
                "    \"lat\": \"30.748093\",\n" +
                "    \"lon\": \"103.973083\",\n" +
                "    \"addr\": \"University of California, Irvine\",\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"mac\": \"86:59:79:be:60:24\",\n" +
                "        \"rssi\": \"-77\",\n" +
                "        \"range\": \"293\",\n" +
                "        \"ts\": \"codingfairy\",\n" +
                "        \"tmc\": \"00:01:02:03:04:05\",\n" +
                "        \"tc\": \"N\",\n" +
                "        \"ds\": \"N\",\n" +
                "        \"essid0\": \"STARBUCKS\",\n" +
                "        \"essid1\": \"CHASE Bank\",\n" +
                "        \"essid2\": \"ALP\",\n" +
                "        \"essid3\": \"home\",\n" +
                "        \"essid4\": \"abcd\",\n" +
                "        \"essid5\": \"xiong\",\n" +
                "        \"essid6\": \"DBH\",\n" +
                "        \"time\": 0,\n" +
                "        \"text\": {\n" +
                "          \"bytes\": [],\n" +
                "          \"length\": 0\n" +
                "        },\n" +
                "        \"longWritable\": {\n" +
                "          \"value\": 0\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        List<ProbeJson> probeJsonList = new Gson().fromJson(
                string, new TypeToken<List<ProbeJson>>(){}.getType());


        ProbeJson probeJsonPrototype = probeJsonList.get(0).clone();
        PhoneJson phoneJsonPrototype = probeJsonList.get(0).getData().get(0);
        phoneJsonPrototype.setRange("5");

        probeJsonList.clear();


        for (int i = 0; i < storeNum; i++) {
            ArrayList<String> macAdd = randomMac(100);
            String[] mac = (String[]) macAdd.toArray(new String[macAdd.size()]);
            for (long time = start; time < end; time+=Math.random()*rand) {

                PhoneJson phoneJson = phoneJsonPrototype.clone();
                phoneJson.setMac(mac[(int)(Math.random()*mac.length)]);
                ArrayList<PhoneJson> dataList = new ArrayList<PhoneJson>();
                dataList.add(phoneJson);

                ProbeJson probeJson = probeJsonPrototype.clone();
                probeJson.setTime(DateFormatter.toString(time));
                probeJson.setData(dataList);

                probeJsonList.add(probeJson);

                count++;
            }
        }
        return probeJsonList;
    }
}
