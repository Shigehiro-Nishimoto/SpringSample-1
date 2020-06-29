//エラーの表示に、順序を持たせるためのインターフェース

package com.example.demo.login.domain.model;

import javax.validation.GroupSequence;

@GroupSequence({ValidGroup1.class, ValidGroup2.class, ValidGroup3.class})
public interface GroupOrder{

}