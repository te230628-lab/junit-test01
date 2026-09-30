package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy; // ← 課題2で追加（例外検証用）
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class calcTest {

    static Calc calc = null;

    @BeforeAll
    static void テスト前処理() {
        calc = new Calc();
    }

    // --- 課題1のテストメソッド群 ---
    @Test
    void addテスト_正常() {
        assertEquals(4, calc.add(1, 3));
    }

    @Test
    void subテスト_正常() {
        assertEquals(2, calc.sub(5, 3));
    }

    @Test
    void multテスト_正常() {
        assertEquals(12, calc.mul(4, 3));
    }

    @Test
    void divテスト_正常() {
        assertEquals(3, calc.div(6, 2));
    }

    // --- 課題2 ここから追加 ---

    @Test
    void divテスト_異常() {
        // 0除算時に ArithmeticException が発生し、メッセージに "by zero" が含まれるか検証
        assertThatThrownBy(() -> {
            calc.div(5, 0);
        })
        .isInstanceOf(ArithmeticException.class)
        .hasMessageContaining("by zero");
    }

    // --- 課題2 ここまで ---

    @AfterAll
    static void テスト後処理() {
        calc = null;
    }
}