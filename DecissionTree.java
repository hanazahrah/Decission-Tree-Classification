/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decissiontree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;

/**
 *
 * @author hana
 */
public class DecissionTree {

    static Random rand = new Random();
    
    
    //Inisiasi populasi
    static int[][] initPop(int popSize){
        int[][] population = new int[popSize][6];
        
        for (int i = 0; i < popSize; i++){
            for (int j = 0; j < 6; j++) {
                population[i][j] = rand.nextInt(2);  
            }
        }
        return population;
    }
    
    static List<List<Integer>> inisiasi(int maxUkPop){
        
        List<List<Integer>> population = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < maxUkPop; i++) {
            /*int randRule = rand.nextInt(4);
            int jumRule = 0;     
            if (randRule == 0){
                jumRule = 15;
            }else if (randRule == 1){
                jumRule = 30;
            }else if (randRule == 2){
                jumRule = 45;
            }else if (randRule == 3){
                jumRule = 60;
            }*/
            List<Integer> individu = new ArrayList<>();
            for (int j = 0; j < 15 ; j++) {
                individu.add(rand.nextInt(2));
            }
            population.add(individu);
        }
        return population;
    }
    
    //Print population
    static void printInteger(List<List<Integer>> population){
        for (int i = 0; i < population.size(); i++) {
            for (int j = 0; j < population.get(i).size(); j++) {
                System.out.print(population.get(i).get(j));   
            }
            System.out.println("");
        }
    }
    
    static void printString(List<List<String>> population){
        for (int i = 0; i < population.size(); i++) {
            for (int j = 0; j < population.get(i).size(); j++) {
                System.out.print(population.get(i).get(j));   
            }
            System.out.println("");
        }
    }
    
    //masukin csv
    static List<List<String>> loadCSV() throws IOException{
        String data = null;
        List<String> thisline;
        List<List<String>> Lines = new ArrayList<List<String>>();
        try {
            BufferedReader readData = new BufferedReader(new FileReader("D:\\AI\\data_latih_opsi_1.csv")); //memanggil file text
            while (readData.readLine() != null) {                
                thisline = Arrays.asList(readData.readLine().split(","));
                Lines.add(thisline);
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DecissionTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lines;
    }
    
    //load data uji
    static List<List<String>> loadCSVuji() throws IOException{
        String data = null;
        List<String> thisline;
        List<List<String>> Lines = new ArrayList<List<String>>();
        try {
            BufferedReader readData = new BufferedReader(new FileReader("D:\\AI\\data_uji_opsi_1.csv")); //memanggil file text
            while (readData.readLine() != null) {                
                thisline = Arrays.asList(readData.readLine().split(","));
                Lines.add(thisline);
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DecissionTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Lines;
    }
    
    //  Encode csv 
    static List<List<Integer>> encodeCSV(List<List<String>> dataCSV){
        List<List<Integer>> encodeCSV = new ArrayList<List<Integer>>();
        for (int i = 0; i < dataCSV.size(); i++) {
            List<Integer> individu = new ArrayList<>();
            for (int j = 0; j < dataCSV.get(i).size(); j++) {
                if(dataCSV.get(i).get(j).matches("rendah") || dataCSV.get(i).get(j).matches("Rendah") ){
                    individu.add(1);
                    individu.add(0);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("normal") || dataCSV.get(i).get(j).matches("Normal")){
                    individu.add(0);
                    individu.add(1);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("tinggi") || dataCSV.get(i).get(j).matches("Tinggi")){
                    individu.add(0);
                    individu.add(0);
                    individu.add(1);
                }else if(dataCSV.get(i).get(j).matches("pagi") || dataCSV.get(i).get(j).matches("Pagi")){
                    individu.add(1);
                    individu.add(0);
                    individu.add(0);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("siang") || dataCSV.get(i).get(j).matches("Siang")){
                    individu.add(0);
                    individu.add(1);
                    individu.add(0);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("sore") || dataCSV.get(i).get(j).matches("Sore")){
                    individu.add(0);
                    individu.add(0);
                    individu.add(1);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("malam") || dataCSV.get(i).get(j).matches("Malam")){
                    individu.add(0);
                    individu.add(0);
                    individu.add(0);
                    individu.add(1);
                }else if(dataCSV.get(i).get(j).matches("cerah") || dataCSV.get(i).get(j).matches("Cerah")){
                    individu.add(1);
                    individu.add(0);
                    individu.add(0);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("berawan") || dataCSV.get(i).get(j).matches("Berawan")){
                    individu.add(0);
                    individu.add(1);
                    individu.add(0);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("rintik") || dataCSV.get(i).get(j).matches("Rintik")){
                    individu.add(0);
                    individu.add(0);
                    individu.add(1);
                    individu.add(0);
                }else if(dataCSV.get(i).get(j).matches("hujan") || dataCSV.get(i).get(j).matches("Hujan")){
                    individu.add(0);
                    individu.add(0);
                    individu.add(0);
                    individu.add(1);
                }else if(dataCSV.get(i).get(j).matches("ya")){
                    individu.add(1);
                }else if(dataCSV.get(i).get(j).matches("tidak")){
                    individu.add(0);
                }    
            }
            encodeCSV.add(individu);   
        }
        return encodeCSV;
    }
    
    //hitung fitness
    static int decission(List<Integer> individu, List<List<Integer>> dataLatih, int i){
        int error = 1;
            int j = 0;
            //while (individu.get(j) != null && error == 1) {
                int jumTrue = 0; //counter jumlah atribut yg benar
                int a = 0; //counter jumlah isi atribut yg benar
                int k = 0;
                //cek atribut pertama
                int n = 0; //variabel untuk menyimpan index yang memiliki value 1
                while (k < 3) {
                    if (dataLatih.get(i).get(k).equals(1)){
                        n = k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut kedua
                while (k < 7) {
                    if (dataLatih.get(i).get(k).equals(1)){
                        n =  k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut ketiga
                while (k < 11) {
                    if (dataLatih.get(i).get(k).equals(1)){
                        n =  k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut keempat
                while (k < 14) {
                    if (dataLatih.get(i).get(k).equals(1)){
                        n = j + k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut kelima
                if (individu.get(j+14).equals(dataLatih.get(i).get(k))){
                    jumTrue = jumTrue + 1;
                }
                //cek apakah data di data latih tersebut error ketika dibandingkan dengan individu 
                if (jumTrue == 5){
                    error = 0;
                }
                //j = j+14;
            //}
        return error;
    }
    
    //rumus fitness
    static int fitness(int n, int error){
        int a = n-error;
        return a/n;
    }
    
    static double[] hitungFitness(List<List<Integer>> individu, List<List<Integer>> dataLatih){
        double[] fitness = new double[individu.size()];
        for (int i = 0; i < individu.size(); i++) {
            int jumError = 0;
            for (int j = 0; j < dataLatih.size(); j++) {
                 int error = decission(individu.get(i), dataLatih, j);
                 jumError = jumError+error; 
            }
            fitness[i] = fitness(dataLatih.size(), jumError);
        }
        return fitness;
    }
    
    //parent selection
    static List<List<Integer>> tournament( List<List<Integer>> population, double[] fitness) {
    List<List<Integer>> temp = new ArrayList<List<Integer>>();
    List<List<Integer>> parent = new ArrayList<List<Integer>>();
    double[] tempFitness = fitness.clone();

        // select random candidate chromosome from population
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 4; i++) {
            int random = rand.nextInt(population.size());
            temp.add(population.get(random));
            tempFitness[i] = fitness[random];
        }
      
        double bestFitness = tempFitness[0];
        int index = 0;

        // select chromosome with the best fitness value from the candidate chromosome
        for (int j = 0; j < 4; j++) {
            if (bestFitness < tempFitness[j]) {
            index = j;
            }
        }

            // selected candidate stored here
            parent.add(temp.get(index));
        }

        return parent;
    }
    
    //Arraylist to array function
    static Integer[][] toArray(List<List<Integer>> parent){
        Integer[][] array = new Integer[parent.size()][];
        for (int i = 0; i < parent.size(); i++) {
            List<Integer> row = parent.get(i);
            array[i] = row.toArray(new Integer[row.size()]);
        }
        return array;
    }
    
    //Array to list function
    static List<List<Integer>> toArraylist(Integer[][] array){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> thisline;
        for (int i = 0; i < array.length; i++) {
            thisline = Arrays.asList(array[i]);
            list.add(thisline);    
        }
        return list;
    }
    
    //Crossover parent to get offspring
    static Integer[][] crossover(Integer[][] parent, double pCrossover){
        double r = rand.nextDouble();
        if (r < pCrossover) {
            Integer[][] child = parent.clone();
            int line = rand.nextInt(15);
            for (int i = line; i < 15; i++) {
                child[0][i] = parent[1][i];
                child[1][i] = parent[0][i];
            }
            return child;
        }
        return parent;
    }
    
    //Child mutation
    static Integer[] mutation(Integer[] child, double pMutation){
        for (int i = 0; i < child.length; i++) {
            double r = rand.nextDouble();
            if (r < pMutation) {
                child[i] = rand.nextInt(2);
            }
        }
        return child;
    }
    
    //Survivor selection by steady state fitness-based
    static Integer[][] steadyState(Integer[][] population, double[] fitness, Integer[][] child){
        
        for (int i = 0; i < child.length; i++) {
            double minfitness = fitness[0];
            int n = 0;
            for (int j = 0; j < fitness.length; j++) {
                if(minfitness > fitness[j]){
                    n = j;
                    minfitness = fitness[j];
                }
            }
            population[n] = child[i].clone();
            
        }
        return population;
    }
    
    //prediksi
    static String[] prediksi(List<Integer> individu, List<List<Integer>> datauji){
        String[] hasil = new String[datauji.size()];
        for (int i = 0; i < datauji.size(); i++) {
            int j = 0;
                int jumTrue = 0; //counte jumlah atribut yg benar
                
                int k = 0;
                //cek atribut pertama
                int n = 0; //variabel untuk menyimpan index yang memiliki value 1
                while (k < 3) {
                    if (datauji.get(i).get(k).equals(1)){
                        n = k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut kedua
                while (k < 7) {
                    if (datauji.get(i).get(k).equals(1)){
                        n =  k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut ketiga
                while (k < 11) {
                    if (datauji.get(i).get(k).equals(1)){
                        n =  k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                //cek atribut keempat
                while (k < 14) {
                    if (datauji.get(i).get(k).equals(1)){
                        n = j + k;
                    }
                    k++;
                }
                if (individu.get(n).equals(1)){
                    jumTrue = jumTrue + 1;
                }
                
                String label;
                if (individu.get(14).equals(1)){
                    label = "ya";
                }else {
                    label = "tidak";
                }
                //cek apakah data di data latih tersebut error ketika dibandingkan dengan individu 
                if (jumTrue == 4){
                    if(individu.get(14).equals(1)){
                        hasil[i] = "ya";
                    } else {
                        hasil[i] = "tidak";
                    }
                } else {
                    if(individu.get(14).equals(0)){
                        hasil[i] = "ya";
                    } else {
                        hasil[i] = "tidak";
                    }
                }
               
         }
        return hasil;
    }
    
    public static void main(String[] args) throws IOException {
     
       int popSize = 1000;
       //Maximum generation
       int maxGen = 3000;
       //Probability crossover
       double Pc = 0.8;
       //Probability mutation
       double Pm = 0.05;
       //inisiasi populasi
       double[] fitness;
       List<List<Integer>> population = inisiasi(popSize);
        List<List<String>> array = loadCSV();
       List<List<Integer>> encode = encodeCSV(array);
       int gen = 0;
       //Looping generation
       while(gen < maxGen){
           fitness = hitungFitness(population, encode);
           Integer[][] parent = toArray(tournament(population, fitness));
           Integer[][] child = crossover(parent, Pc);
            //Child mutation
            Integer[][] childm = child.clone();
            childm[0] = mutation(child[0], Pm).clone();
            childm[1] = mutation(child[1], Pm).clone();
            
            Integer[][] pop = steadyState(toArray(population), fitness, childm);
             population = toArraylist(pop);
           gen++;
       }
       
       //looping generasi selesai
       //find best fitness of all chromosome in last generation
       fitness = hitungFitness(population, encode);
        double max = fitness[0];
            int id = 0;
            for (int i = 0; i < fitness.length; i++) {
                if (max < fitness[i]) {
                    id = i;
                    max = fitness[i];
                }
            }
        
        List<List<String>> datauji = loadCSVuji();
        List<List<Integer>> encodeuji = encodeCSV(datauji);
        String[] prediksi = prediksi(population.get(id), encodeuji);
        
        for (int i = 0; i < prediksi.length; i++) {
            System.out.println(prediksi[i]); 
            
        }
    }    
}
