package com.tospay.nbresource.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class TospayUser implements Parcelable {
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("type_id")
        @Expose
        private String typeId;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_verified")
        @Expose
        private boolean emailVerified;
        @SerializedName("expired_at")
        @Expose
        private Long expiredAt;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("refresh_token")
        @Expose
        private String refreshToken;
        @SerializedName("firstname")
        @Expose
        private String firstname;
        @SerializedName("lastname")
        @Expose
        private String lastname;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("country_name")
        @Expose
        private String countryName;
        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("timezone")
        @Expose
        private String timezone;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("phone_verified")
        @Expose
        private boolean phoneVerified;
        @SerializedName("profile_pic")
        @Expose
        private String profilePic;
        @SerializedName("country")
        @Expose
        private Country country;
        @SerializedName("address")
        @Expose
        private Address address;
        @SerializedName("country_emoji")
        @Expose
        private String countryEmoji;
        @SerializedName("static_qr")
        @Expose
        private String staticQr;
        public static final Creator<TospayUser> CREATOR = new Creator<TospayUser>() {
            public TospayUser createFromParcel(Parcel in) {
                return new TospayUser(in);
            }

            public TospayUser[] newArray(int size) {
                return new TospayUser[size];
            }
        };

        public TospayUser() {
        }

        protected TospayUser(Parcel in) {
            this.userId = in.readString();
            this.typeId = in.readString();
            this.email = in.readString();
            this.emailVerified = in.readByte() != 0;
            if (in.readByte() == 0) {
                this.expiredAt = null;
            } else {
                this.expiredAt = in.readLong();
            }

            this.token = in.readString();
            this.refreshToken = in.readString();
            this.firstname = in.readString();
            this.lastname = in.readString();
            this.name = in.readString();
            this.countryCode = in.readString();
            this.countryName = in.readString();
            this.language = in.readString();
            this.timezone = in.readString();
            this.phone = in.readString();
            this.currency = in.readString();
            this.phoneVerified = in.readByte() != 0;
            this.profilePic = in.readString();
            this.countryEmoji = in.readString();
            this.staticQr = in.readString();
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.userId);
            dest.writeString(this.typeId);
            dest.writeString(this.email);
            dest.writeByte((byte)(this.emailVerified ? 1 : 0));
            if (this.expiredAt == null) {
                dest.writeByte((byte)0);
            } else {
                dest.writeByte((byte)1);
                dest.writeLong(this.expiredAt);
            }

            dest.writeString(this.token);
            dest.writeString(this.refreshToken);
            dest.writeString(this.firstname);
            dest.writeString(this.lastname);
            dest.writeString(this.name);
            dest.writeString(this.countryCode);
            dest.writeString(this.countryName);
            dest.writeString(this.language);
            dest.writeString(this.timezone);
            dest.writeString(this.phone);
            dest.writeString(this.currency);
            dest.writeByte((byte)(this.phoneVerified ? 1 : 0));
            dest.writeString(this.profilePic);
            dest.writeString(this.countryEmoji);
            dest.writeString(this.staticQr);
        }

        public int describeContents() {
            return 0;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTypeId() {
            return this.typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmailVerified() {
            return this.emailVerified;
        }

        public void setEmailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        public Long getExpiredAt() {
            return this.expiredAt;
        }

        public void setExpiredAt(Long expiredAt) {
            this.expiredAt = expiredAt;
        }

        public String getToken() {
            return this.token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getRefreshToken() {
            return this.refreshToken;
        }

        public void setRefreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
        }

        public String getFirstname() {
            return this.firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return this.lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountryName() {
            return this.countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getLanguage() {
            return this.language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getTimezone() {
            return this.timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public String getPhone() {
            return this.phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCurrency() {
            return this.currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public boolean isPhoneVerified() {
            return this.phoneVerified;
        }

        public void setPhoneVerified(boolean phoneVerified) {
            this.phoneVerified = phoneVerified;
        }

        public String getProfilePic() {
            return this.profilePic;
        }

        public void setProfilePic(String profilePic) {
            this.profilePic = profilePic;
        }

        public Country getCountry() {
            return this.country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        public Address getAddress() {
            return this.address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getCountryEmoji() {
            return this.countryEmoji;
        }

        public void setCountryEmoji(String countryEmoji) {
            this.countryEmoji = countryEmoji;
        }

        public String getStaticQr() {
            return this.staticQr;
        }

        public void setStaticQr(String staticQr) {
            this.staticQr = staticQr;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.firstname == null && this.lastname == null ? this.name : this.firstname + " " + this.lastname;
        }

        public String toString() {
            return "TospayUser{userId='" + this.userId + '\'' + ", typeId='" + this.typeId + '\'' + ", email='" + this.email + '\'' + ", emailVerified=" + this.emailVerified + ", expiredAt=" + this.expiredAt + ", token='" + this.token + '\'' + ", refreshToken='" + this.refreshToken + '\'' + ", firstname='" + this.firstname + '\'' + ", lastname='" + this.lastname + '\'' + ", name='" + this.name + '\'' + ", countryCode='" + this.countryCode + '\'' + ", countryName='" + this.countryName + '\'' + ", language='" + this.language + '\'' + ", timezone='" + this.timezone + '\'' + ", phone='" + this.phone + '\'' + ", currency='" + this.currency + '\'' + ", phoneVerified=" + this.phoneVerified + ", profilePic='" + this.profilePic + '\'' + ", country=" + this.country + ", address=" + this.address + ", countryEmoji='" + this.countryEmoji + '\'' + ", staticQr='" + this.staticQr + '\'' + '}';
        }
    }


