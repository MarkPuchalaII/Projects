def reader(reference):
    try:
        #open a data file and split it with commas to look like "[data, data, data]"
        with open(reference) as file:
            data = file.readline()
        name = data.strip().split(',')

        #Sanitize() cleans up the data
        #make a set that removes duplicate information
        #sort the first three
        #AND PRINT!
        print(sorted(set([sanitize(each) for each in name]))[0:3])
    except IOError as ioerr:
        print('File error: ' + str(ioerr))
        return(None)


def sanitize(time_string):

    #check each iteraction for '-'s and ':'s
    if '-' in time_string:
        splitter = '-'
    elif ':' in time_string:
        splitter = ':'
    else:
        return(time_string)

    #Split all iterations
    #replace all '-'s and ':'s with '.'
    #and return "#.#"
    (mins, secs) = time_string.split(splitter)
    return(mins + '.' + secs)



reader('james.txt')
reader('julie.txt')
reader('mikey.txt')
reader('sarah.txt')
