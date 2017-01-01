package com.jackie.baigu.okhttp.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/31.
 */
public class DataBean {


    private List<ItemData> trailers;

    public List<ItemData> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<ItemData> trailers) {
        this.trailers = trailers;
    }

    public static class ItemData {
        /**
         * id : 63996
         * movieName : 《西游伏妖篇》动作版预告
         * coverImg : http://img5.mtime.cn/mg/2016/12/28/162417.51435462.jpg
         * movieId : 208325
         * url : http://vfx.mtime.cn/Video/2016/12/27/mp4/161227204134063682_480.mp4
         * hightUrl : http://vfx.mtime.cn/Video/2016/12/27/mp4/161227204134063682.mp4
         * videoTitle : 西游伏妖篇  打斗版预告片
         * videoLength : 123
         * rating : -1
         * type : ["动作","奇幻","喜剧","古装"]
         * summary : 唐僧挥鞭打大圣 片尾有彩蛋
         */

        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private int rating;
        private String summary;
        private List<String> type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
