package com.bank;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class DBUtil {
    private static Map<String, User> userMap = new HashedMap();
    static {
        String path = DBUtil.class.getClassLoader().getResource("user.xlsx").getPath();

        File resource = new File(path);
        XSSFWorkbook sheets = null;
        try {
            sheets = new XSSFWorkbook(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        XSSFSheet userSheet = sheets.getSheetAt(0);
        int lastRowNum = userSheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = userSheet.getRow(i);
            for (int j = 0; j < 4; j++) {
                row.getCell(j).setCellType(CellType.STRING);
            }
            String userName = row.getCell(0).getStringCellValue();
            String cardId = row.getCell(1).getStringCellValue();
            String cardPwd = row.getCell(2).getStringCellValue();
            String call = row.getCell(3).getStringCellValue();
            double account = row.getCell(4).getNumericCellValue();
            User user = new User(userName, cardId, cardPwd, call, account);
            userMap.put(user.getCardId(), user);
        }

    }
    public static User getUserByCardId(String cardId) {
        return userMap.get(cardId);
    }

    public static List<User> getAllUser() {
        return new ArrayList(userMap.values());
    }
}
