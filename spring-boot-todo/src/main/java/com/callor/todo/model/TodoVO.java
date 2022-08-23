package com.callor.todo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "tbl_todo",schema = "bootdb")
public class TodoVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column()
    private String username;

    @Column(length = 10)
    private String s_date;

    @Column(length = 10)
    private String s_time;

    @Column(length = 2000)
    private String content;

    @Column(length = 10)
    private String e_date;

    @Column(length = 10)
    private String e_time;

    @Column()
    private boolean comp;


}
