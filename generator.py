for meter_id in range(1, 150000):
    for year in range (2023, 2024):
        for month in (1, 12):
            for day in range (1, 28):
                print("%d,%d-%02d-%02d,1.0"%(meter_id, year, month, day))