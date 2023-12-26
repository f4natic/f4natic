Контракт equals() и hashCode() в Java определяет правила, которым должны следовать классы при переопределении этих методов.   
Переопределение методов equals() и hashCode() является важным для правильной работы сравнения и хэширования объектов в Java.

Контракт equals():
- Рефлексивность:   
Метод equals() должен быть рефлексивным, то есть для любого ненулевого объекта x, x.equals(x) должен возвращать true.
- Симметричность:   
Если объект x.equals(y) возвращает true, то и y.equals(x) должен возвращать true.
- Транзитивность:   
Если объект x.equals(y) и y.equals(z) возвращают true, то и x.equals(z) должен возвращать true.
- Консистентность:   
Повторные вызовы x.equals(y) должны возвращать одинаковый результат, если ни одно из полей объекта не изменилось.
- Необходимость проверки на null:   
Метод equals() должен возвращать false, если переданный объект obj равен null.
- Согласованность с hashCode():   
Если два объекта равны согласно методу equals(), то их хэш-коды, возвращаемые методом hashCode(), должны быть равными.

Контракт hashCode():
- Согласованность с equals():   
Если два объекта равны согласно методу equals(), то их хэш-коды, возвращаемые методом hashCode(), должны быть равными.
- Различность для неравных объектов:   
Два неравных объекта могут иметь одинаковые хэш-коды, но хорошая реализация метода hashCode() должна минимизировать вероятность коллизий (когда разные объекты имеют одинаковый хэш-код).
- Консистентность:   
Повторные вызовы метода hashCode() должны возвращать одинаковый результат, если ни одно из полей объекта не изменилось.