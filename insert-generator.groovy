import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.Period
import java.time.ZoneOffset
import java.util.Random

def jan_1_2023 = LocalDate.of(2023, Month.JANUARY, 1)

def feb_1_2023 = LocalDate.of(2023, Month.FEBRUARY, 1)

def start = jan_1_2023

def end = feb_1_2023

def random = new Random()

new File('measurements.csv').withWriter { out ->
    for (meter_id in 1..1000) {
        start.upto(end) {
            def dayStart = it << LocalTime.MIDNIGHT << ZoneOffset.ofHours(0)
            def dayEnd = (it + Period.ofDays(1)) << LocalTime.MIDNIGHT << ZoneOffset.ofHours(0)

            def current = dayStart

            while (current < dayEnd) {
                out.println("""${meter_id},${it},${current.format('yyyy-MM-dd HH:mm:ss')}.000+0000,${it}, ${random.nextDouble()}""")

                current += Duration.ofMinutes(15)
            }
        }
    }
}
