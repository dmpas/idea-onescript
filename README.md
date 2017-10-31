# Расширение поддежки Односкрипта в Idea

Подсветка синтаксиса, поддержка свёртки процедур и функций. Совместима с любой IDE на основе IntelliJ IDEA.

## Установка

1. Качаем jar из раздела [выпусков](releases)
2. Устанавливаем расширение с диска, указав скачанный jar-архив
3. Перезапускаем Idea/Rider/...

## Сборка и доработка

1. Настраиваем среду разработки согласно [инструкции](http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/prerequisites.html).
2. Запускаем создание классов для `OneScript.bnf`
3. Запускаем создание классов для `OneScript.flex` - Idea попросит указать путь установки JFlex
4. Собираем проект
5. Запускаем отладку (Run - Debug) или собираем пакет расширения (Build - Prepare Plugin Module For Deployment)
