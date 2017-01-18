package com.allstate.services;

import com.allstate.entities.EncrypDecryp;
import com.allstate.repositories.IEncrypDecrypRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class EncrypDecrypService {
    private IEncrypDecrypRepo repository;

    @Autowired
    public void setRepository(IEncrypDecrypRepo repository) {
        this.repository = repository;
    }
    private String keyValue = "123";
    public byte[] generateKey(String keyValue) throws NoSuchAlgorithmException {
        byte[] keys = keyValue.getBytes();
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        keys = sha.digest(keys);
        keys = Arrays.copyOf(keys, 32);
        return keys;
    }

    public String encrypt(String password){
        String encryptedText = "";
        try {
            Cipher encryptedcipher = Cipher.getInstance("AES");
            byte[] encryptkey = generateKey(keyValue);
            SecretKeySpec secretKey = new SecretKeySpec(encryptkey, "AES");
            encryptedcipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] inputbytes = password.getBytes();
            byte[] outputbytes = encryptedcipher.doFinal(inputbytes);
            encryptedText = Base64Utils.encodeToString(outputbytes);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException ex) {
            System.out.println(ex);
        }
        System.out.println(encryptedText);
        return encryptedText;
    }

    public EncrypDecryp encryptPassword(EncrypDecryp encryp) {
        encryp.setPassword_carrier(encrypt(encryp.getPassword_carrier()));
        encryp.setFlag(1);
        return this.repository.save(encryp);
    }

    public EncrypDecryp updatePassword(EncrypDecryp encryp){
        EncrypDecryp encrypselect = this.repository.findByCarrier(encryp.getCarrier());
        encrypselect.setUsername_carrier(encryp.getUsername_carrier());
        encrypselect.setPassword_carrier(encrypt(encryp.getPassword_carrier()));
        encrypselect.setFlag(1);
        return this.repository.save(encrypselect);
    }
}
