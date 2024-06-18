package com.bankmgt.demo.repo;

import com.bankmgt.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account, Long> {
}
