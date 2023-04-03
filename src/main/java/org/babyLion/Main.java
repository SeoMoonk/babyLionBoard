package org.babyLion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean programStatus = true;
        int postCount = 1;

//        BabyLionException babyLionException = new BabyLionException();

        List<Post> postList = new ArrayList<>();

        while(programStatus)
        {
            System.out.print("명령어 : ");
            String command = sc.nextLine().trim();


            System.out.println("입력한 명령어는? = " + command);

            switch(command)
            {

                case "remove" :
                    System.out.println("이전에 작성된 게시물을 삭제합니다.");
                    System.out.printf("게시물 번호를 정수로 입력해 주세요. 현재 최대 번호 : %d", postCount);
                    String removeInputId = sc.nextLine().trim();

                    postList.remove(Integer.parseInt(removeInputId) -1);

                case "update" :
                    System.out.println("이전에 작성된 게시물을 수정합니다.");
                    System.out.printf("게시물 번호를 정수로 입력해주세요. 현재 최대 번호 : %d ", postCount);
                    String updateInputId = sc.nextLine().trim();

                    try {

                        int postId = Integer.parseInt(updateInputId);
                        Post findPost = postList.get(postId -1);

                        System.out.println("수정 전 제목 : " + findPost.getTitle());
                        System.out.print("수정할 제목 : ");
                        String updateTitle = sc.nextLine().trim();

                        System.out.println("수정 전 내용 : " + findPost.getBody());
                        System.out.print("수정할 내용 : ");
                        String updateBody = sc.nextLine().trim();

                        findPost.setTitle(updateTitle);
                        findPost.setBody(updateBody);
                        findPost.setUpdatedDate(LocalDate.now());



                    } catch(NumberFormatException e) {
                        System.out.println("게시물 번호는 정수로만 입력해주세요.");
                    }


                case "view" :
                    System.out.println("이전에 작성된 게시물을 조회합니다.");
                    System.out.printf("게시물 번호를 정수로 입력해주세요. 현재 최대 번호 : %d \n", postCount);

                    System.out.print("게시물 번호 : ");
                    String viewInputId = sc.nextLine().trim();

                    try {
                        int input = Integer.parseInt(viewInputId);

                        Post findPost = postList.get(input - 1);

                        System.out.println("findPost = " + findPost.toString());

                    } catch(NumberFormatException e) {
                        System.out.println("게시물 번호는 정수로만 입력해주세요.");
                    } catch(IndexOutOfBoundsException e) {
                        System.out.println("게시물 번호를 한번만 더 확인해 주세요.");
                    } catch(Exception e) {
                        System.out.println("!!!error!!! : 올바르지 않은 입력입니다.");
                    }


                case "write" :
                    System.out.println("게시글을 작성합니다.");

                    System.out.print("제목 : ");
                    String title = sc.nextLine().trim();

                    System.out.print("내용 :");
                    String body = sc.nextLine().trim();

                    postList.add(new Post(postCount, title, body));

                    System.out.println("작성한 글 = " + postList.get(postCount).toString());
                    postCount++;

                    break;
                case "exit" :
                    System.out.println("프로그램을 종료합니다.");
                    programStatus = false;
                    break;

                default :
                    System.out.println("존재하지 않는 명령어 입니다.");
            }
        }

        sc.close();
    }
}
