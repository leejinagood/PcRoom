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
            for(int i=0; i<3; i++){
                System.out.print(".");
                Thread.sleep(1000);
            }

            System.out.println("\n환영합니다");
            Thread.sleep(1000);
            System.out.print("아이디를 입력하시오 \n(아이디를 만들려면 No를 입력해주세요) ->");
            String ans = scan.next();

            if(ans.equals("No")){
                System.out.println("회원가입 진행합니다");
                Thread.sleep(1000);
                System.out.println("아이디를 입력해주세요 : ");
                String Id = scan.next();
                System.out.println("비밀번호를 입력해주세요 : ");
                String Pwd = scan.next();

            }

            for(int i=1; i<=5; i++) {

                System.out.println("올바른 아이디가 아닙니다. 다시 입력해주세요 ->");
            }

            System.out.println("비밀번호를 입력하시오");
    }
}

