package com.my_home.domain.finance;

import com.my_home.domain.finance.Finance;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "[finance]")
@Entity(name = "finance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Finance {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String description;
  private Integer amount;
  private String note;
  // private User user;
  private Integer transactionType;
  // private String category;
  // private String account;

  public Finance(RequestFinance requestFinance) {
    this.description = requestFinance.description();
    this.amount = requestFinance.amount();
    this.note = requestFinance.note();
    this.transactionType = requestFinance.transactionType();
  }
}
