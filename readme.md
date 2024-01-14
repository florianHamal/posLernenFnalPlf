
this is a test project with undlean code !!! 
the notes are just some things i have a hard time keeping in my mind

<h3>JPA</h3>
object:

```java
@Entity
```
subobjects
```java
@ManyToOne <- car.location
@Joincolum
@OneToMany <- location.cars
@Enumerate
```
for json reading:
```
fetch = FetchType.EAGER
```

repository:

```java
interface CarRepository extends JpaRepository<Object,PkeyType>
```

<h3>Spring</h3>
/{location}

```java
@PathVariable String location
```


<h3>Jackson</h3>

```java
@ManagedReferance  -> cascade all
@JsonBackReference
```

```java
objectmapper.readerForListOf.read();
objectmapper.writeValue();
```

<h3>Thymeleaf</h3>
resources/templates folder

object benötigt endpoint
```html
<form th:object=${object} method="post" th:action="@{endpoint}">
	<li th:each="i : ${object}">
		<input type="radio" th:value="${i.name}" th:field="{name}">
		<label th:text="${i.name}"></label>
	</li>
	<input type="submit" value="absenden">
</form>
```


macht @RequestParam
```html
<form th:object=${object} method="post" th:action="@{endpoint}">
	<input type="hidden" th:value="${i.name}" name="${name}">
	<input type="submit" value="absenden">
</form>
```


@ModelAttribute("locationSelection")
Model model

<h3>CSS</h3>
/static

```css
tbody > tr:first-child
{
	color: red;
	font-weight: bolder;
}
tbody > tr:first-child > td:last-child;
{
	fisplay: none;
}
table, th, td
{
	border 1px solid black;
}
```