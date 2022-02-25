package API;

import java.util.ArrayList;

public class UserLoginData {
  private Float basket_lines;
  private String basket_sum;
  private String sms;
  private String url;
  private String data_url;
  private String session;
  private String login;
  private String login_type;
  private String name;
  private String phone;
  private String position;
  private String rg;
  private String city;
  private String photo;
  private String net;
  private String org_id;
  private String org_name;
  private String bonus;
  private String st;
  private String cli812type;
  private String st_132;
  private String change_pwd;
  private String old_pwd;
  private String email;
  private String page;
  private String man_id;
  private String ankid;
  private String opros;
  private String prc_type_cli;
  ArrayList < Object > org_list = new ArrayList < Object > ();
  private Boolean show_ipro3;

  public UserLoginData(Float basket_lines, String basket_sum, String sms, String url,
                       String data_url, String session, String login, String login_type,
                       String name, String phone, String position, String rg, String city,
                       String photo, String net, String org_id, String org_name, String bonus,
                       String st, String cli812type, String st_132, String change_pwd, String old_pwd,
                       String email, String page, String man_id, String ankid, String opros, String prc_type_cli,
                       ArrayList<Object> org_list, Boolean show_ipro3)
  {
    this.basket_lines = basket_lines;
    this.basket_sum = basket_sum;
    this.sms = sms;
    this.url = url;
    this.data_url = data_url;
    this.session = session;
    this.login = login;
    this.login_type = login_type;
    this.name = name;
    this.phone = phone;
    this.position = position;
    this.rg = rg;
    this.city = city;
    this.photo = photo;
    this.net = net;
    this.org_id = org_id;
    this.org_name = org_name;
    this.bonus = bonus;
    this.st = st;
    this.cli812type = cli812type;
    this.st_132 = st_132;
    this.change_pwd = change_pwd;
    this.old_pwd = old_pwd;
    this.email = email;
    this.page = page;
    this.man_id = man_id;
    this.ankid = ankid;
    this.opros = opros;
    this.prc_type_cli = prc_type_cli;
    this.org_list = org_list;
    this.show_ipro3 = show_ipro3;
  }

  public Float getBasket_lines() {
    return basket_lines;
  }

  public String getBasket_sum() {
    return basket_sum;
  }

  public String getSms() {
    return sms;
  }

  public String getUrl() {
    return url;
  }

  public String getData_url() {
    return data_url;
  }

  public String getSession() {
    return session;
  }

  public String getLogin() {
    return login;
  }

  public String getLogin_type() {
    return login_type;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getPosition() {
    return position;
  }

  public String getRg() {
    return rg;
  }

  public String getCity() {
    return city;
  }

  public String getPhoto() {
    return photo;
  }

  public String getNet() {
    return net;
  }

  public String getOrg_id() {
    return org_id;
  }

  public String getOrg_name() {
    return org_name;
  }

  public String getBonus() {
    return bonus;
  }

  public String getSt() {
    return st;
  }

  public String getCli812type() {
    return cli812type;
  }

  public String getSt_132() {
    return st_132;
  }

  public String getChange_pwd() {
    return change_pwd;
  }

  public String getOld_pwd() {
    return old_pwd;
  }

  public String getEmail() {
    return email;
  }

  public String getPage() {
    return page;
  }

  public String getMan_id() {
    return man_id;
  }

  public String getAnkid() {
    return ankid;
  }

  public String getOpros() {
    return opros;
  }

  public String getPrc_type_cli() {
    return prc_type_cli;
  }

  public ArrayList<Object> getOrg_list() {
    return org_list;
  }

  public Boolean getShow_ipro3() {
    return show_ipro3;
  }
}
