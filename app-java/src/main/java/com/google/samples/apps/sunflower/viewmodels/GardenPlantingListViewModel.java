/*
 * Copyright 2019 Shawn Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlanting;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * Created by Shawn Wang on 3/27/19.
 */
public class GardenPlantingListViewModel extends ViewModel {
    public LiveData<List<GardenPlanting>> gardenPlantings;
    public LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings;

    GardenPlantingListViewModel(@NonNull GardenPlantingRepository repository) {
        this.gardenPlantings = repository.getGardenPlantings();
        this.plantAndGardenPlantings = Transformations.map(repository.getPlantAndGardenPlantings(), items -> {
            List<PlantAndGardenPlantings> removeItems = new ArrayList<>();
            for (PlantAndGardenPlantings item:items) {
                if (item.getGardenPlantings().isEmpty()) {
                    removeItems.add(item);
                }
            }
            items.removeAll(removeItems);
            return items;
        });
    }
}
