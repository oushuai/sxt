package com.sxt.crud;

import com.sxt.crud.pojo.Menu;
import com.sxt.crud.pojo.Role;
import com.sxt.crud.repository.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author ouyangjie
 * @createTime 2019-12-13 15:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CrudApplication.class)
public class TestManyToMany {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testSave() {
        Role role = new Role("小香猪", "找工作");
        Set<Menu> menus = new HashSet<>();
        Menu menu = new Menu();
        menu.setMenuName("菜单管理");
        Menu menu1 = new Menu();
        menu1.setParentId(menu);
        menu1.setMenuName("项目管理");
        menus.add(menu);
        menus.add(menu1);
        role.getMenus().add(menu);
        //role.getMenus().add(menu1);
        menu1.getRole().add(role);
        menu.getRole().add(role);
        roleRepository.save(role);
    }
    @Test
    public void testFind(){
        Optional<Role> role=roleRepository.findById("c99c27b8-1b70-4989-a195-f216791da7da");
        //查询完以后操作对象的session关闭，hibernate默认延迟加载
        Set<Menu> menus=role.get().getMenus();
        for (Menu menu:menus){
            System.out.println(menu.getMenuName());
        }
    }
}
