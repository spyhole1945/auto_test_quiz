Feature: 员工报销申请流程


  Background:
    Given 打开测试网站
    And 在左边栏点击Claims进入页面
    And 点击Employee Claims

  @positive
  Scenario: 成功创建并提交员工报销申请
    When 添加一条Assign Claims记录
    And 填写Create Claim Request表单:
      | Field          | Value           |
      | Employee Name | Amelia Brown    |
      | Event          | Travel allowances |
      | Currency       | Euro            |
    And 点击Create按钮
    Then 验证成功提示信息"Successfully Saved"
    And 跳转至Assign Claim详情页
    And 验证详情页数据与表单填写一致:
      | Field          | Expected Value  |
      | Employee Name | Amelia Brown    |
      | Event          | Travel allowances |
      | Currency       | Euro            |
    When 添加Expenses
    And 填写Expense表单:
      | Field         | Value           |
      | Expense Type  | Accommodation   |
      | Date          | 2025-08-19      |
      | Amount        | 548.00          |
    And 点击Submit按钮
    Then 验证成功提示信息"Successfully Submitted"
    And 检查Expense数据与填写数据一致:
      | Field         | Expected Value  |
      | Expense Type  | Accommodation   |
      | Date          | 2025-08-19      |
      | Amount        | 548.00          |
    When 点击Back返回
    Then 验证Record中存在提交记录:
      | Employee Name | Amelia Brown    |
      | Event          | Travel allowances |
      | Currency       | Euro            |
      | Date          | 2025-08-19      |
      | Amount        | 548.00          |