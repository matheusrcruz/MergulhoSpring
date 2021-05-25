package com.easy.easylog.execptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Problem {
	//Objeto para trazer na resposta da exeption
  private Integer status;
  private LocalDateTime dateTime;
  private String title;
  private List<Inputs> input;
  
  @AllArgsConstructor
  @Getter
  public static class Inputs{
	  
	  private String name;
	  private String msg;
	  
  }

}
