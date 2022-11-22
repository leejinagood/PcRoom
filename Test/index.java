package Test;

import java.sql.*;
import java.util.Scanner;

public class index {
    public static void main(String[] args) throws SQLException, InterruptedException {
            Scanner scan = new Scanner(System.in);

            //DB연결
            Connection conn = null;
            String dbURL = "jdbc:mysql://localhost:3306/PcRoomProject";
            PreparedStatement pstmt;
            ResultSet UserRs;
            ResultSet FoodRs;
            ResultSet TimeRs;
            ResultSet GameRs;

            String dbID = "root";
            String dbPassword = "abcd1234";
            try {
                //드라이버 로딩
                Class.forName("com.mysql.cj.jdbc.Driver");
                //Connection생성
                conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            }catch (Exception e){
                System.out.println("실패");
            }
            Statement stmt = conn.createStatement();
            UserRs = stmt.executeQuery("select * from UserDB"); //RS에 데이터 담기
            FoodRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Food;");
            TimeRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Time;");
            GameRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Game;");


            System.out.print("프로그램 로딩 중입니다");
            for(int i=0; i<1; i++){
                System.out.print(".");
                Thread.sleep(1000);
            }

            System.out.println("\n환영합니다");
            Thread.sleep(1000);
            System.out.print("아이디를 입력하시오 \n(아이디를 만들려면 No를 입력해주세요) ->");
            String ans = scan.next();

            //회원가입 알고리즘
            String Pwd ;
            String Pwd1 ;
            String Id = null;
            if(ans.equals("No")||ans.equals("no")) {
                while(true) {
                    System.out.println("회원가입 진행합니다");
                    Thread.sleep(1000);
                    System.out.print("아이디를 입력해주세요 : ");
                    Id = scan.next();
                    System.out.print("비밀번호를 입력해주세요 : ");
                    Pwd = scan.next();
                    System.out.print("비밀번호를 한번 더 입력해주세요 : ");
                    Pwd1 = scan.next();
                    if(Pwd.equals(Pwd1)){
                        break;
                    }
                    else{
                        System.out.println("비밀번호가 다릅니다 다시 시작합니다...");
                        Thread.sleep(1000);
                    }
                }
                    System.out.print("전화번호를 입력해주세요 : ");
                    String Phone = scan.next();
                    System.out.print("이메일을 입력해주세요 : ");
                    String Email = scan.next();
                    System.out.print("이메일 수신 동의합니까?(동의:Y, 비동의:N) : ");
                    String EmailOK = scan.next();
                    int RsInsert;
                    RsInsert = stmt.executeUpdate("insert into PcRoomProject.UserDB(ID, PWD, Phone, Email,E_Alarm) value('" + Id + "', '" + Pwd + "', '" + Phone + "', '" + Email + "', '" + EmailOK + "');");
            }



            ResultSet rs;
            rs = stmt.executeQuery("SELECT ID FROM PcRoomProject.UserDB where ID="+ans+";");
            System.out.print("비밀번호를 입력하세요 -> ");
            String PwdOK = scan.next();

            if(rs == null){
            for(int i=5; i<=1; i--) {
                System.out.println("올바른 비밀번호가 아닙니다. 다시 입력해주세요("+i+"번) ->");
                }
            }

    }
}


