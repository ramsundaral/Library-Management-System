package LibraryManagementSystem;

import java.io.*;
import java.util.Scanner;

public class Main {
    static String[][] studentDatabase = new String[6][4];
    static Scanner sc = new Scanner(System.in);
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            String s;
            int row = 0;
            FileReader fr = new FileReader("StudentData.txt");
            BufferedReader br = new BufferedReader(fr);
            while ((s = br.readLine()) != null) {
                studentDatabase[row] = s.split(",");
                row++;
            }
            fr.close();
            br.close();
            System.out.print("User ID : ");
            String userid = sc.nextLine();
            System.out.print("Password : ");
            String pwd = sc.nextLine();
            int found = 0;
            for (int i = 1; i < studentDatabase.length; i++) {
                String pwdcheck = studentDatabase[i][2] + "" + studentDatabase[i][1].toLowerCase();
                if (studentDatabase[i][2].equals(userid) && pwdcheck.equals(pwd)) {
                    System.out.println("---Successfully logged in---");
                    found = 1;
                    Student s1 = new Student();
                    s1.user(studentDatabase[i][0], Integer.parseInt(studentDatabase[i][3]));
                    return;
                }
            }
            if (found == 0) {
                System.out.println("---No records---");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void rewriteData(String old, String filename, String newstr,int index,int process) {
        String currentLine;
        int occur=1;
        File inputFile = new File(filename);
        File tempFile = new File("TempFile.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(old) && process == 2 && occur == 1) {
                    occur = 0;
                    continue;
                }
                if (currentLine.contains(old) && process==1) {
                    String[] ar = currentLine.split(",");
                    currentLine="";
                    ar[index]=newstr;
                    for(int i=0;i<ar.length;i++){
                        if(i==ar.length-1){
                            currentLine+=ar[i];
                        }
                        else {
                            currentLine += ar[i] + ",";
                        }
                    }
                }
                writer.write(currentLine + "\n");
            }
            writer.close();
            reader.close();
            System.gc();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            System.out.println("error");
        }

    }
}
