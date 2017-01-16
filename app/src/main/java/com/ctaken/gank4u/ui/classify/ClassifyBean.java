package com.ctaken.gank4u.ui.classify;

import java.util.List;

/**
 * Created by chentaikang on 2017/1/16 12:49.
 */
public class ClassifyBean {


        /**
         * _id : 5876e99a421aa93161103df2
         * createdAt : 2017-01-12T10:27:38.322Z
         * desc : iOS 实用饼状图
         * images : ["http://img.gank.io/d7fe7489-4712-4913-9707-d78c20f97927","http://img.gank.io/4a68aa88-faef-47ae-bbd8-f3d209da049f"]
         * publishedAt : 2017-01-12T11:30:59.369Z
         * source : chrome
         * type : iOS
         * url : https://github.com/i-schuetz/PieCharts
         * used : true
         * who : 代码家
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;

    }
}
