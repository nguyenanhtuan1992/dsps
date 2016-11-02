package org.dcps.dsps.utils;

import org.dcps.dsps.entity.dao.SuperEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Cicada on 11/1/2016.
 */
public class SessionUtils {
    public static final String ACCOUNT_INFOR = "ACCOUNT_INFOR";
    public static final String CURRENT_SUPER_EVENT = "CURRENT_SUPER_EVENT";


    /**
     * Get session
     * @param objectName
     * @return
     */
    public static Object get(String objectName) {
        HttpServletRequest request = null; // HttpServletRequestUtils.getRequest();
        if (request == null) {
            return null;
        } else {
            HttpSession session = request.getSession(true);
            if (session == null) {
                return null;
            }
            return session.getAttribute(objectName);
        }
    }

    /**
     * Remove Session
     * @param objectName
     */
    public static void remove(String objectName) {
        HttpServletRequest request = null; // HttpServletRequestUtils.getRequest();
        if (request != null) {
            HttpSession session = request.getSession(true);
            if (session != null) {
                session.removeAttribute(objectName);
            }
        }

    }

    /**
     * Set session
     * @param objectName
     * @param object
     */
    public static void set(String objectName, Object object) {
        HttpServletRequest request = null; //HttpServletRequestUtils.getRequest();
        if (request != null) {
            HttpSession session = request.getSession(true);
            if (session != null) {
                session.setAttribute(objectName, object);
            }
        } else {
            //do nothing
        }
    }

    /**
     * get current account
     * @return
     */
    /*public static Account getCurrentAccount() {
        Account account = (Account) SessionUtils.get(SessionUtils.ACCOUNT_INFOR);

        if (account == null) {
            SecurityContextHolder.clearContext();
            throw new SystemException("", "");
        }
        return account;
    }*/

    /**
     * Get current Super Event
     * @return
     */
    public static SuperEvent getSuperEvent() {
        SuperEvent superEvent = (SuperEvent) SessionUtils.get(SessionUtils.CURRENT_SUPER_EVENT);
        if (superEvent == null){
            throw new RuntimeException("You need choice a SuperEvent");
        }
        return superEvent;
    }



}
