package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class DefaultDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateReqDto {
        private Boolean deleted;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private Boolean deleted;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class DeletesReqDto {
        private List<Long> ids;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class CreateResDto {
        private Long id;
    }

    //여기는 빌더 사용 금지!!
    @AllArgsConstructor
    @NoArgsConstructor
    @Setter
    @Getter
    public static class DetailResDto {
        private Long id;
        private Boolean deleted;
        private LocalDateTime createdAt;
        private String createdAtDateTime;
        private LocalDateTime modifiedAt;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ListReqDto {
        private Boolean deleted;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto {
        private Integer callpage; // 요청 페이지
        private String orderby; //정렬 기준
        private String orderway; //정렬 방향

        private Integer perpage; //한페이지에 몇개 보여줄지
        private Integer offset; //몇번째 정보부터 보여줄지

        private Boolean deleted;
        private String sdate; //검색일 시작
        private String fdate; //검색일 종료
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListResDto {
        private Integer callpage;
        private Integer totalCount;
        private Integer totalPage;
        private Integer perpage;

        private Object list;

        public static PagedListResDto init(PagedListReqDto param, int totalCount){
            //offset 을 구하기 위함!!
            Integer perpage = param.getPerpage();
            if(perpage == null){
                param.setPerpage(10);
                perpage = param.getPerpage();
            } else {
                if(perpage <= 0){
                    param.setPerpage(10);
                    perpage = param.getPerpage();
                }
            }

            int totalPage = totalCount / perpage;
            if(totalCount % perpage != 0){
                totalPage++;
            }
            int callpage = param.getCallpage();
            if(callpage < 1){ callpage = 1; }
            if(callpage > totalPage){ callpage = totalPage; }
            int offset = (callpage - 1) * perpage;
            if(offset < 0){ offset = 0; }
            if(offset > totalCount){ offset = totalCount; }
            param.setOffset(offset);

            //정렬 기준
            String orderby = param.getOrderby();
            if(orderby == null || orderby.isEmpty()){
                orderby = "created_at";
            }
            param.setOrderby(orderby);

            //정렬 방향
            String orderway = param.getOrderway();
            if(orderway == null || orderway.isEmpty()){
                orderway = "desc";
            }
            param.setOrderway(orderway);

            return PagedListResDto.builder()
                    .totalCount(totalCount)
                    .totalPage(totalPage)
                    .callpage(callpage)
                    .build();
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter
    @Getter
    public static class ScrollListReqDto {
        private String orderway; //정렬 방향
        private Integer perpage; //한페이지에 몇개 보여줄지
        private Long cursor; // 기준이 되는 정보를 가지고 있는 id 값
        private String createdAt;// 시간값을 정해주려고 합니다!

        private Boolean deleted;

        public void init(){
            Integer perpage = getPerpage();
            if(perpage == null){
                setPerpage(10);
            } else {
                if(perpage < 0){
                    setPerpage(10);
                }
            }
            //정렬 방향
            String orderway = getOrderway();
            if(orderway == null || orderway.isEmpty()){
                orderway = "desc";
            }
            setOrderway(orderway);
        }
    }
}