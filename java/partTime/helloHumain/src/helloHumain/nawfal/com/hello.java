package helloHumain.nawfal.com;

@SpringBootApplication
@RestController
public class hello {
	public static void main(String[] args) {
		SpringApplication.run(hello.class, args);

	}

	@RequestMapping("/")
	public String index(@RequestParam(value = "name") String name, @RequestParam(value = "last_name") String last_name){
		   
		
			return "Hollo " + name+" "+last_name;
}
