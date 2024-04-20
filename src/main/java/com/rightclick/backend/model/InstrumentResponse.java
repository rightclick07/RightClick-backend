package com.rightclick.backend.model;

public class InstrumentResponse {
        private RedirectInfo redirectInfo;
        private String type;

        public RedirectInfo getRedirectInfo() {
            return redirectInfo;
        }

        public void setRedirectInfo(RedirectInfo redirectInfo) {
            this.redirectInfo = redirectInfo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
