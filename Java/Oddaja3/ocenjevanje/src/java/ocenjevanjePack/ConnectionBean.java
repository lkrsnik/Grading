/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ocenjevanjePack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luka
 */
public class ConnectionBean {
    public boolean getGrading(GradingBean grading) {
            PreparedStatement ps = null;
            boolean res=false;
            try {
                    //String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('63110179', 'Krsnik', 'blabla', 'blabla', 'blabla', 'Luka', 'Krsnik', 'luka.krsnik2@hotmail.com', '040914122', '1')"
                    //String sql = "INSERT INTO `prpo13_projekt08`.`UPORABNIK` (`id`, `ime`, `priimek`, `naslov`, `postna_stevilka`, `posta`, `davcna_stevilka`, `email`, `telefon`, `datum_rojstva`, `podjetje_davcna`, `podjetje_maticna`, `podjetje_SKD`, `davcni_zavezanec`, `podjetje_datum_vpisa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    String sql = "SELECT * FROM krsnik_faks_b1.Grading;";
                                 // INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('11111111', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe@qwe.qwe', '123132132', '2');

                    Connection conn=getConnection();
                    ps = conn.prepareStatement(sql);
                    
                    
                    ResultSet rs = ps.executeQuery();
                    //int rs = ps.executeUpdate();
                    if (rs.next()) {
                        grading.setAsist(rs.getString("asist"));
                        grading.setStud(rs.getString("stud"));
                        grading.setInstructions(rs.getString("instructions"));
                        grading.setProf(rs.getString("prof"));
                        res=true;
                          //  ((Uporabnik) osebek).setIme(rs.getString("ime"));
                          //  ((Uporabnik) osebek).setPriimek(rs.getString("priimek"));
                    } else {
                       
                    }

            } catch (SQLException e) {
                    System.out.println("Oh, to je pa nerodno.");
            } finally {
                    if (ps != null)
                            try {
                                    ps.close();
                            } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                            }
            }
            
            return res;
    }
    
    
    public void changeGrading(GradingBean grading) {
        PreparedStatement ps = null;
        try {
                //String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('63110179', 'Krsnik', 'blabla', 'blabla', 'blabla', 'Luka', 'Krsnik', 'luka.krsnik2@hotmail.com', '040914122', '1')"
                //String sql = "INSERT INTO `prpo13_projekt08`.`UPORABNIK` (`id`, `ime`, `priimek`, `naslov`, `postna_stevilka`, `posta`, `davcna_stevilka`, `email`, `telefon`, `datum_rojstva`, `podjetje_davcna`, `podjetje_maticna`, `podjetje_SKD`, `davcni_zavezanec`, `podjetje_datum_vpisa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                String sql = "UPDATE `krsnik_faks_b1`.`Grading` SET `asist`=?, `stud`=?, `instructions`=?, `prof`=? WHERE `id`='0';";
                           // UPDATE `krsnik_faks_b1`.`Grading` SET `asist`='1', `stud`='2', `instructions`='asd', `prof`='3' WHERE `id`='0';
                //System.out.println("Še sem tukaj.0");

                Connection conn=getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, (grading.getAsist()));
                ps.setString(2, (grading.getStud()));
                ps.setString(3, (grading.getInstructions()));
                ps.setString(4, (grading.getProf()));
                
                //System.out.println("Še sem tukaj.1");
                //ResultSet rs = ps.executeQuery();
                int rs = ps.executeUpdate();
                //System.out.println("Še sem tukaj.2");


        } catch (SQLException e) {
                e.printStackTrace();
                
        } finally {
                if (ps != null)
                        try {
                                ps.close();
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
        }
        
    }
    public void addProject(ProjectBean project){
        PreparedStatement ps = null;
        try {
                //String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('63110179', 'Krsnik', 'blabla', 'blabla', 'blabla', 'Luka', 'Krsnik', 'luka.krsnik2@hotmail.com', '040914122', '1')"
                //String sql = "INSERT INTO `prpo13_projekt08`.`UPORABNIK` (`id`, `ime`, `priimek`, `naslov`, `postna_stevilka`, `posta`, `davcna_stevilka`, `email`, `telefon`, `datum_rojstva`, `podjetje_davcna`, `podjetje_maticna`, `podjetje_SKD`, `davcni_zavezanec`, `podjetje_datum_vpisa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                String sql = "INSERT INTO `krsnik_faks_b1`.`Projects` (`title`, `platform`, `mate1`, `mate2`, `projectSource`, `codeSource`) VALUES (?, ?, ?, ?, ?, ?);";
                           // INSERT INTO `krsnik_faks_b1`.`Projects` (`title`, `platform`, `mate1`, `mate2`, `projectSource`, `codeSource`) VALUES ('project1', 'Android', 'Janez Novak', 'Micka Prešeren', 'http://www.google.com', 'http://www.gmail.com');


                Connection conn=getConnection();
                ps = conn.prepareStatement(sql);
                ps.setString(1, (project.getTitle()));
                ps.setString(2, (project.getPlatform()));
                ps.setString(3, (project.getMate1()));
                ps.setString(4, (project.getMate2()));
                ps.setString(5, (project.getProjectSource()));
                ps.setString(6, (project.getCodeSource()));
                //System.out.println("Še sem tukaj.1");
                //ResultSet rs = ps.executeQuery();
                int rs = ps.executeUpdate();
                //System.out.println("Še sem tukaj.2");


        } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Projekt s takšnim naslovom že obstaja.");
        } finally {
                if (ps != null)
                        try {
                                ps.close();
                        } catch (SQLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
        }
    }
    
    public void insertUser(UserBean user) {
            PreparedStatement ps = null;
            try {
                    //String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('63110179', 'Krsnik', 'blabla', 'blabla', 'blabla', 'Luka', 'Krsnik', 'luka.krsnik2@hotmail.com', '040914122', '1')"
                    //String sql = "INSERT INTO `prpo13_projekt08`.`UPORABNIK` (`id`, `ime`, `priimek`, `naslov`, `postna_stevilka`, `posta`, `davcna_stevilka`, `email`, `telefon`, `datum_rojstva`, `podjetje_davcna`, `podjetje_maticna`, `podjetje_SKD`, `davcni_zavezanec`, `podjetje_datum_vpisa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                                 // INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('11111111', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe@qwe.qwe', '123132132', '2');

                    Connection conn=getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, (user.getNumber()));
                    ps.setString(2, (user.getName()));
                    ps.setString(3, (user.getPass()));
                    ps.setString(4, (user.getPass1()));
                    ps.setString(5, (user.getPass2()));
                    ps.setString(6, (user.getFname()));
                    ps.setString(7, (user.getSname()));
                    ps.setString(8, (user.getEmail()));
                    ps.setString(9, (user.getPhone()));
                    ps.setString(10,(user.getRole()));
                    //System.out.println("Še sem tukaj.1");
                    //ResultSet rs = ps.executeQuery();
                    int rs = ps.executeUpdate();
                    //System.out.println("Še sem tukaj.2");
                    

            } catch (SQLException e) {
                    System.out.println("Vaša vpisna številka že obstaja.");
            } finally {
                    if (ps != null)
                            try {
                                    ps.close();
                            } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                            }
            }

    }
    public boolean getUser(String name,String pass,UserBean user) {
            PreparedStatement ps = null;
            boolean res=false;
            try {
                    //String sql = "INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('63110179', 'Krsnik', 'blabla', 'blabla', 'blabla', 'Luka', 'Krsnik', 'luka.krsnik2@hotmail.com', '040914122', '1')"
                    //String sql = "INSERT INTO `prpo13_projekt08`.`UPORABNIK` (`id`, `ime`, `priimek`, `naslov`, `postna_stevilka`, `posta`, `davcna_stevilka`, `email`, `telefon`, `datum_rojstva`, `podjetje_davcna`, `podjetje_maticna`, `podjetje_SKD`, `davcni_zavezanec`, `podjetje_datum_vpisa`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    String sql = "SELECT * FROM krsnik_faks_b1.Users WHERE name=? && pass=?;";
                                 // INSERT INTO `krsnik_faks_b1`.`Users` (`number`, `name`, `pass`, `pass1`, `pass2`, `fname`, `sname`, `email`, `phone`, `role`) VALUES ('11111111', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe', 'qwe@qwe.qwe', '123132132', '2');

                    Connection conn=getConnection();
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, (name));
                    ps.setString(2, (pass));
                    
                    ResultSet rs = ps.executeQuery();
                    //int rs = ps.executeUpdate();
                    if (rs.next()) {
                        user.setNumber(rs.getString("number"));
                        user.setFname(rs.getString("fname"));
                        user.setSname(rs.getString("sname"));
                        user.setEmail(rs.getString("email"));
                        user.setPhone(rs.getString("phone"));
                        user.setRole(rs.getString("role"));
                        res=true;
                          //  ((Uporabnik) osebek).setIme(rs.getString("ime"));
                          //  ((Uporabnik) osebek).setPriimek(rs.getString("priimek"));
                    } else {
                       
                    }

            } catch (SQLException e) {
                    System.out.println("Oh, to je pa nerodno.");
            } finally {
                    if (ps != null)
                            try {
                                    ps.close();
                            } catch (SQLException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                            }
            }
            
            return res;
    }
    
    public Connection getConnection() {
            String url = "jdbc:mysql://mysql.lrk.si:3306/krsnik_faks_b1";
            Connection conn = null;

            try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = DriverManager.getConnection(url, "krsnik_faks", "krsnik_faks");
            } catch (SQLException | InstantiationException | IllegalAccessException
                            | ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return conn;
    }

    
}
