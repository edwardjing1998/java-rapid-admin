package admin.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "CURRENT_PASSWORD")
    private String currentPassword;

    @Column(name = "ACCESS_LEVEL")
    private String accessLevel;

    @Column(name = "FDRID")
    private String fdrid;

    @Column(name = "FDRPWD")
    private String fdrpwd;

    @Column(name = "FDRPWDEXP")
    private Short fdrpwdexp;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "OPERATOR_CD")
    private String operatorCD;

    @Column(name = "LAST_LOGON_DATE")
    private LocalDateTime lastLogonDate;

    @Column(name = "REPORT_GRP_ID")
    private String reportGrpId;

    @Column(name = "PASSWORD")
    private String password;

    // Password history fields
    @Column(name = "PASSWORD2") private String password2;
    @Column(name = "PASSWORD3") private String password3;
    @Column(name = "PASSWORD4") private String password4;
    @Column(name = "PASSWORD5") private String password5;
    @Column(name = "PASSWORD6") private String password6;
    @Column(name = "PASSWORD7") private String password7;
    @Column(name = "PASSWORD8") private String password8;
    @Column(name = "PASSWORD9") private String password9;
    @Column(name = "PASSWORD10") private String password10;
    @Column(name = "PASSWORD11") private String password11;
    @Column(name = "PASSWORD12") private String password12;
    @Column(name = "PASSWORD13") private String password13;
    @Column(name = "PASSWORD14") private String password14;
    @Column(name = "PASSWORD15") private String password15;
    @Column(name = "PASSWORD16") private String password16;
    @Column(name = "PASSWORD17") private String password17;
    @Column(name = "PASSWORD18") private String password18;
    @Column(name = "PASSWORD19") private String password19;
    @Column(name = "PASSWORD20") private String password20;

    @Column(name = "TIMEDPASSWORD")
    private LocalDateTime timedPassword;

    @Column(name = "LOGEDIN")
    private String logedIn;

    // Standard getters and setters...

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getCurrentPassword() { return currentPassword; }
    public void setCurrentPassword(String currentPassword) { this.currentPassword = currentPassword; }

    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }

    public String getFdrid() { return fdrid; }
    public void setFdrid(String fdrid) { this.fdrid = fdrid; }

    public String getFdrpwd() { return fdrpwd; }
    public void setFdrpwd(String fdrpwd) { this.fdrpwd = fdrpwd; }

    public Short getFdrpwdexp() { return fdrpwdexp; }
    public void setFdrpwdexp(Short fdrpwdexp) { this.fdrpwdexp = fdrpwdexp; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getOperatorCD() { return operatorCD; }
    public void setOperatorCD(String operatorCD) { this.operatorCD = operatorCD; }

    public LocalDateTime getLastLogonDate() { return lastLogonDate; }
    public void setLastLogonDate(LocalDateTime lastLogonDate) { this.lastLogonDate = lastLogonDate; }

    public String getReportGrpId() { return reportGrpId; }
    public void setReportGrpId(String reportGrpId) { this.reportGrpId = reportGrpId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPassword2() { return password2; }
    public void setPassword2(String password2) { this.password2 = password2; }

    public String getPassword3() { return password3; }
    public void setPassword3(String password3) { this.password3 = password3; }

    public String getPassword4() { return password4; }
    public void setPassword4(String password4) { this.password4 = password4; }

    public String getPassword5() { return password5; }
    public void setPassword5(String password5) { this.password5 = password5; }

    public String getPassword6() { return password6; }
    public void setPassword6(String password6) { this.password6 = password6; }

    public String getPassword7() { return password7; }
    public void setPassword7(String password7) { this.password7 = password7; }

    public String getPassword8() { return password8; }
    public void setPassword8(String password8) { this.password8 = password8; }

    public String getPassword9() { return password9; }
    public void setPassword9(String password9) { this.password9 = password9; }

    public String getPassword10() { return password10; }
    public void setPassword10(String password10) { this.password10 = password10; }

    public String getPassword11() { return password11; }
    public void setPassword11(String password11) { this.password11 = password11; }

    public String getPassword12() { return password12; }
    public void setPassword12(String password12) { this.password12 = password12; }

    public String getPassword13() { return password13; }
    public void setPassword13(String password13) { this.password13 = password13; }

    public String getPassword14() { return password14; }
    public void setPassword14(String password14) { this.password14 = password14; }

    public String getPassword15() { return password15; }
    public void setPassword15(String password15) { this.password15 = password15; }

    public String getPassword16() { return password16; }
    public void setPassword16(String password16) { this.password16 = password16; }

    public String getPassword17() { return password17; }
    public void setPassword17(String password17) { this.password17 = password17; }

    public String getPassword18() { return password18; }
    public void setPassword18(String password18) { this.password18 = password18; }

    public String getPassword19() { return password19; }
    public void setPassword19(String password19) { this.password19 = password19; }

    public String getPassword20() { return password20; }
    public void setPassword20(String password20) { this.password20 = password20; }

    public LocalDateTime getTimedPassword() { return timedPassword; }
    public void setTimedPassword(LocalDateTime timedPassword) { this.timedPassword = timedPassword; }

    public String getLogedIn() { return logedIn; }
    public void setLogedIn(String logedIn) { this.logedIn = logedIn; }
}
