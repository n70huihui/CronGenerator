# 🚀 CronGenerator Plugin for JetBrains IDEs

**A lightweight tool designed for developers to quickly generate and validate Cron expressions directly within your IDE.**  
**专为开发者设计的轻量级工具，帮助您在IDE中快速生成Cron表达式**

[![JetBrains Plugin](https://img.shields.io/badge/JetBrains%20Plugin-CronGenerator-%23007EC6
)](https://plugins.jetbrains.com/plugin/27767-crongenerator)
[![Downloads](https://img.shields.io/badge/downloads-latest-%2344CC11
)](https://plugins.jetbrains.com/plugin/27767-crongenerator/versions)

---

## ✨ 核心功能 (Core Features)
1. **可视化配置 (Visual Configuration)**：通过图形界面选择时间规则（秒/分/时/日/月/周/年），自动生成标准 Cron 表达式。

2. **实时预览 (Real-time Preview)**：动态展示未来 5 次执行时间，避免调度逻辑错误。

3. **快速键入 (Quick Insertion)**：一键插入表达式到代码编辑器，支持 **IntelliJ IDEA**、**PyCharm** 等 JetBrains 全家桶（支持版本：2025 及以上）。


## 🛠️ 安装指南 (Installation)
### 方式一：IDE 在线安装 (Recommended)
1. 打开 IDE → `Settings` > `Plugins` > `Marketplace`
2. 搜索 **"CronGenerator"**
3. 点击 `Install` 并重启 IDE

### 方式二：手动安装
1. 下载 [最新版本插件](https://plugins.jetbrains.com/plugin/27767-crongenerator/versions)
2. `Settings` > `Plugins` > ⚙️ > `Install Plugin from Disk...`
3. 选择下载文件并重启 IDE


## 🔍 同类工具对比 (Comparison)
| 功能                | 本插件               | 在线生成器  | Vue-Cron   |
|---------------------|----------------------|------------------------|------------------------|
| **IDE 集成**        | ✅ 直接嵌入          | ❌ 需切换浏览器         | ❌ 仅 Web 项目          |
| **实时预览**        | ✅ 未来 5 次执行时间 | ⚠️ 部分支持            | ✅                     |
| **表达式快速插入**  | ✅ 一键插入代码      | ❌ 手动复制            | ❌ 需手动粘贴           |


## 📄 开源协议 (License)
本项目采用 [MIT License](https://opensource.org/licenses/MIT)  
Copyright © 2025 [n70huihui]