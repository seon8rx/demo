package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

public class DefaultDto {

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto {
        private Boolean deleted;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateResDto {
        private Long id;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto {
        private Long id;
        private Boolean deleted;

    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class LoginResDto {
        private boolean result;
        private Long id; //식별자 역할?
        private String username;
    }

    //여기는 빌더 사용 금지
    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto {
        private Long id;
        private Boolean deleted;
        private LocalDateTime createdAt;
        private String createdAtDateTime;
        private LocalDateTime modifiedAt;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ListReqDto {
        private Boolean deleted;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto {
        private int callpage; // 요청 페이지
        private String orderby; //정렬 기준
        private String orderway; //정렬 방향

        private Integer perpage; //한페이지에 몇개 보여줄지
        private Integer offset; //몇번째 정보부터 보여줄지
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListResDto {
        private int itemcount;
        private int pagecount;
        private int callpage;
        private Object list;

        public static PagedListResDto init(PagedListReqDto param, int itemcount) {
            Integer perpage = param.getPerpage();
            if(perpage == null) {
                perpage = 10;
            }
            //int itemcount = faqMapper.pagedListCount(param);
            int pagecount = itemcount / perpage;

            if(itemcount % perpage > 0) {
                pagecount++;
            }
            int callpage = param.getCallpage();
            if(callpage < 1) {
                callpage = 1;
            }
            if(callpage > pagecount) {
                callpage = pagecount;
            }
            int offset = (callpage - 1) * perpage;

            param.setOffset(offset);

            String orderby = param.getOrderby();
            if(orderby == null || "".equals(orderby)) {
                orderby = "created_at";
            }

            String orderway = param.getOrderway();
            if(orderway == null || "".equals(orderway)) {
                orderway = "desc";
            }

            DefaultDto.PagedListResDto returnVal = DefaultDto.PagedListResDto.builder()
                    .itemcount(itemcount).pagecount(pagecount).callpage(callpage)
                    .build();

            return returnVal;
        }

    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto {
        private String orderway; //정렬 방향
        private Integer perpage; //한페이지에 몇개 보여줄지
        private Long cursor;
        private String createdAt;

        private Boolean deleted;

        public void init() {
            Integer perpage = getPerpage();
            if(perpage == null) {
                setPerpage(10);
            } else {
                if(perpage < 0) {
                    setPerpage(10);
                }
            }

            String orderway = getOrderway();
            if(orderway == null || "".equals(orderway)) {
                orderway = "desc";
            }

            setOrderway(orderway);
        }

    }

}