package com.c.refactoring.menuexamples;

import java.util.Arrays;
import java.util.List;

public class MenuAccessSolution {

    public void setAuthorizationsInEachMenus(List<MenuItem> menuItemsList, Role[] roles) {
        if(roles == null){
            return;
        }
        menuItemsList.stream()
                .forEach(menuItem -> setAccessForMenuItems(menuItem, roles));

    }

    private void setAccessForMenuItems(MenuItem menuItem, Role[] roles) {
        if(doUserHasAnyRole(roles,menuItem.getReadAccessRole())){
            menuItem.setAccess(Constants.READ);
            menuItem.setVisible(true);
        }
        if(doUserHasAnyRole(roles, menuItem.getWriteAccessRole())){
            menuItem.setAccess(Constants.WRITE);
            menuItem.setVisible(true);
        }
    }

    private boolean doUserHasAnyRole(Role[] roles, String userAccessRole) {
        return Arrays.stream(roles)
                .anyMatch(role -> role.getName().equals(userAccessRole));
    }
}
