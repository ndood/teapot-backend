package org.teapot.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teapot.backend.dao.abstr.UserDao;
import org.teapot.backend.dao.abstr.UserRoleDao;
import org.teapot.backend.model.User;
import org.teapot.backend.model.UserRole;
import org.teapot.backend.service.abstr.UserService;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public void disable(User user) {
        user.setAvailable(false);
        userDao.update(user);
    }

    @Override
    public void enable(User user) {
        user.setAvailable(true);
        userDao.update(user);
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> getAllByUserRole(UserRole role) {
        return userDao.getList()
                .stream()
                .filter(user -> user.getRoles().contains(role))
                .collect(Collectors.toList());
    }

    @Override
    public void assignUserRole(User user, UserRole role) {
        if (userRoleDao.getByUserRoleName(role.getName()) == null) {
            userRoleDao.insert(role);
        }

        user.getRoles().add(role);
        userDao.update(user);
    }

    @Override
    public void removeUserRole(User user, UserRole role) {
        user.getRoles().remove(role);
        userDao.update(user);
    }

    @Override
    public boolean hasUserRole(User user, UserRole role) {
        return user.getRoles() != null
                && user.getRoles().contains(role);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public List<User> getList(Integer offset, Integer count) {
        return userDao.getList(offset, count);
    }
}
