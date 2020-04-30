/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uminho.pt.aa.data;

import di.uminho.pt.aa.business.*;
import di.uminho.pt.aa.data.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josepereira
 */
public class Populate {
    public static void main (String[] args){
        GMS gms = new GMS();
        
        Platform megadrive = new Platform();
        megadrive.setName("MegaDrive");
        megadrive.setDescription("A 16-bit home video game console.");
        megadrive.setManufacture("SEGA");
        megadrive.setYear(1988);
        try {
            gms.registarPlatform(megadrive);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }
        Platform pc = new Platform();
        pc.setName("PC");
        pc.setDescription("A personal computer (PC) is a multi-purpose electronic computer whose size, capabilities, and price make it feasible for individual use.");
        pc.setManufacture("N/A");
        pc.setYear(1977);
        try {
            gms.registarPlatform(pc);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }
        Platform ps4 = new Platform();
        ps4.setName("Playstation 4");
        ps4.setDescription("The PlayStation 4 (abbreviated as PS4) is a home video game console developed by Sony Computer Entertainment.");
        ps4.setManufacture("SONY");
        ps4.setYear(2013);
        try {
            gms.registarPlatform(ps4);
        } catch (PlatformExistsException e) {
            e.printStackTrace();
        }
        Game sonic = new Game();
        sonic.setName("Sonic the Hedgehog");
        sonic.setPrice(60.0f);
        sonic.setDescription("Sonic the Hedgehog is a platform video game developed by Sonic Team and published by Sega for the Sega Genesis console.");
        sonic.setYear(1991);
        sonic.setPlatform(megadrive);
        try {
            gms.registarGame(sonic);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
        Game dune = new Game();
        dune.setName("Dune");
        dune.setPrice(65.0f);
        dune.setDescription("Dune: The Battle for Arrakis is a real-time strategy Dune video game developed by Westwood Studios.");
        dune.setYear(1993);
        dune.setPlatform(megadrive);
        try {
            gms.registarGame(dune);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
        Game halfLife3 = new Game();
        halfLife3.setName("Half Life 3");
        halfLife3.setPrice(60.0f);
        halfLife3.setDescription("Half-Life 3 is a first-person shooter video game developed and published by Valve Corporation.");
        halfLife3.setYear(2018);
        halfLife3.setPlatform(pc);
        try {
            gms.registarGame(halfLife3);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
        Game ageOfEmpires = new Game();
        ageOfEmpires.setName("Age of Empires");
        ageOfEmpires.setPrice(70.0f);
        ageOfEmpires.setDescription("Age of Empires is a series of personal computer games developed by Ensemble Studios (defunct in 2009) and published by Microsoft Studios.");
        ageOfEmpires.setYear(1997);
        ageOfEmpires.setPlatform(pc);
        try {
            gms.registarGame(ageOfEmpires);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
        Game gtaV = new Game();
        gtaV.setName("GTA V");
        gtaV.setPrice(70.0f);
        gtaV.setDescription("Grand Theft Auto V is an action-adventure video game developed by Rockstar North and published by Rockstar Games.");
        gtaV.setYear(2013);
        gtaV.setPlatform(ps4);
        try {
            gms.registarGame(gtaV);
        } catch (GameExistsException e) {
            e.printStackTrace();
        }
        Collection<Game> games = new ArrayList();
        games.add(sonic);
        games.add(gtaV);
        User user = new User();
        user.setUsername("Joana");
        user.setEmail("joanan@email");
        try {
            user.setPassword(Checksum.getFileChecksum("password".getBytes(), MessageDigest.getInstance("SHA-256")));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Populate.class.getName()).log(Level.SEVERE, null, ex);
        }
        user.setGames(games);
        try {
            gms.registerUser(user);
        } catch (UserExistsException e) {
            e.printStackTrace();
        }
    }
}
