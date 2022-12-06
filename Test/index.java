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
        } catch (Exception e) {
            System.out.println("실패");
        }
        Statement stmt = conn.createStatement();
        UserRs = stmt.executeQuery("select * from UserDB"); //RS에 데이터 담기
        FoodRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Food;");
        TimeRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Time;");
        GameRs = stmt.executeQuery("SELECT * FROM PcRoomProject.Game;");


        System.out.print("프로그램 로딩 중입니다");
        for (int i = 0; i < 1; i++) {
            System.out.print(".");
            Thread.sleep(1000);
        }

        System.out.println("\n환영합니다");
        Thread.sleep(1000);
        System.out.print("아이디를 입력하시오 \n(아이디를 만들려면 No를 입력해주세요) ->");
        String ans = scan.next();

        //회원가입 알고리즘
        String Pwd;
        String Pwd1;
        String Id = null;
        if (ans.equals("No") || ans.equals("no")) {
            while (true) {
                System.out.println("회원가입 진행합니다");
                Thread.sleep(1000);
                System.out.print("아이디를 입력해주세요 : ");
                Id = scan.next();
                System.out.print("비밀번호를 입력해주세요 : ");
                Pwd = scan.next();
                System.out.print("비밀번호를 한번 더 입력해주세요 : ");
                Pwd1 = scan.next();
                if (Pwd.equals(Pwd1)) {
                    break;
                } else {
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
            System.out.println("회원가입이 정상정으로 완료되었습니다.");
        }

        //로그인 기능
        ResultSet rs;
        System.out.print("비밀번호를 입력하세요 -> ");
        String PwdOK = scan.next();
        String SQL = "SELECT PWD FROM PcRoomProject.UserDB WHERE ID=?;";
        String userID = null, userPassword = null;
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, ans);
            rs = pstmt.executeQuery();
            if (rs.next()) { //다음것이있나?true/false로 반환
                if (rs.getString(1).equals(PwdOK)) {
                    //sql로 실행한 비번과 접속시도한 비번이 맞으면 로그인 성공
                    System.out.println("환영합니다.");
                    Thread.sleep(1000);
                } else {
                    System.out.println("비밀번호가 다릅니다.");
                    System.out.print("다시 시작하세요");
                    System.exit(0); //강제종료
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.print("=======메뉴판=======\n 1.음식 주문 \n 2.요금제 주문 \n 3.계정정보 수정 \n 4.게임시작 \n 5.종료\n==================\n(1,2,3,4,5) ->>");
            String ans2 = scan.next();

            //1. 음식주문
            if (ans2.equals("1")) {

            }

            //2. 요금제 주문
            else if (ans2.equals("2")) {

            }

            //3.계정정보 수정
            else if (ans2.equals("3")) {

            }

            //4. 게임시작
            else if (ans2.equals("4")) {

            }

            //5. 종료
            else if (ans2.equals("5")){
                System.out.println("종료합니다..");
                Thread.sleep(1000);
                break;
            }

            //잘못된 입력값을 받으면 재입력
            else {
                System.out.println("잘못된 입력입니다. \n");
            }
        }
    }
}


