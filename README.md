# Selenium-Java

Java + Selenium Web 自动化测试学习仓库（2019-2020），覆盖多种主流自动化测试设计与集成方式。

## 子项目一览

| 目录 | 说明 |
|---|---|
| `loginPO` / `TestPO` / `testProjectPo` | Page Object 模式实践（登录场景、电商站点） |
| `TestProject` / `TestNGWeb` | TestNG 驱动的基础 Web 自动化 |
| `SeleniumKeywordDrive` | 关键字驱动框架实践 |
| `KeyDriver` | 键盘事件驱动练习 |
| `JenkinsUITest` / `JenkinsAutoTest` / `LevelJenkins` | Selenium + Jenkins 持续集成，Allure 报告输出 |
| `AutoTestMTX2019` | 综合自动化练习项目 |
| `web_01` ~ `web_04` | 跟随 lemon 教学课程的分阶段实战 |

## 技术栈

Java 8 + Selenium WebDriver + TestNG + Maven + Jenkins + Allure

## 运行

各子项目独立 Maven 构建，在对应目录执行：

```bash
mvn clean test
```

Allure 报告生成方式见 `Maven运行生成Allure报表.txt`。
