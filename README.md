# Расширение поддержки OneScript и исходников 1С в Idea

Поддерживаются файлы с расширениями `.os` и `.bsl`

Подсветка синтаксиса, поддержка свёртки процедур и функций. Совместима с любой IDE на основе `IntelliJ IDEA`.

![image](https://user-images.githubusercontent.com/2920817/41089771-4dccacee-6a4b-11e8-9edc-c336990bedfa.png)

## Установка

1. Качаем jar из раздела [выпусков](https://github.com/dmpas/idea-onescript/releases)
2. Устанавливаем расширение с диска, указав скачанный jar-архив - `File - Settings - Plugins - Install from disk`
3. Перезапускаем `Idea/Rider/...`

## Сборка и доработка

1. Настраиваем среду разработки согласно [инструкции](http://www.jetbrains.org/intellij/sdk/docs/tutorials/custom_language_support/prerequisites.html).
2. Запускаем создание классов для `OneScript.bnf`
3. Запускаем создание классов для `OneScript.flex` - Idea попросит указать путь установки JFlex
4. Собираем проект
5. Запускаем отладку (`Run - Debug`) или собираем пакет расширения (`Build - Prepare Plugin Module For Deployment`)
